/**
 * Copyright 2018 Greg Whitaker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package proteus.example.client;

import io.netifi.proteus.Proteus;
import io.netifi.proteus.rsocket.ProteusSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import proteus.example.service.vowelcount.VowelCountRequest;
import proteus.example.service.vowelcount.VowelCountServiceClient;
import reactor.core.publisher.Flux;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Client that sends random strings to the VowelCount service to have the number
 * of vowels in the string counted.
 */
public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String... args) throws Exception {
        Long accessKey = getAccessKeyFromArgs(args);
        String accessToken = getAccessTokenFromArgs(args);

        // Define connection to the Proteus Broker
        final Proteus proteus = Proteus.builder()
                .group("proteus.example.client")    // Name of this client's group
                .destination("democlient")          // Name of this client
                .accessKey(accessKey)               // Access key for connecting to Proteus Broker
                .accessToken(accessToken)           // Access token for connecting to Proteus Broker
                .host("localhost")                  // Proteus Broker's host
                .port(8001)                         // Proteus Broker's port
                .build();

        // Create virtual connection to the VowelCount service group
        ProteusSocket conn = proteus.group("proteus.example.service.vowelcount");

        CountDownLatch latch = new CountDownLatch(1);

        // Generate stream of random strings
        Flux<VowelCountRequest> requests = Flux.range(1, 100)
                .map(cnt -> VowelCountRequest.newBuilder()
                        .setMessage(RandomString.next(10, ThreadLocalRandom.current()))
                        .build());

        // Send stream of random strings to vowel count service
        VowelCountServiceClient client = new VowelCountServiceClient(conn);
        client.countVowels(requests)
                .onBackpressureDrop()
                .doOnComplete(latch::countDown)
                .subscribe(response -> {
                    LOGGER.info("Total Vowels: {}", response.getVowelCnt());
                });

        latch.await();
    }

    /**
     * Gets the access key to use for the demo from the command line arguments.
     *
     * @param args command line arguments
     * @return access key
     */
    private static Long getAccessKeyFromArgs(String... args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Invalid number of arguments");
        }

        return Long.parseLong(args[0]);
    }

    /**
     * Gets the access token to use for the demo from the command line arguments.
     *
     * @param args command line arguments
     * @return access token
     */
    private static String getAccessTokenFromArgs(String... args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Invalid number of arguments");
        }

        return args[1];
    }
}
