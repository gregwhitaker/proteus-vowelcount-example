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
import org.reactivestreams.Subscription;
import proteus.example.service.vowelcount.VowelCountRequest;
import proteus.example.service.vowelcount.VowelCountResponse;
import proteus.example.service.vowelcount.VowelCountServiceClient;
import reactor.core.publisher.Flux;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Client that sends random strings to the VowelCount service to have the number
 * of vowels in the string tallied.
 */
public class Main {

    public static void main(String... args) throws Exception {
        Long accessKey = getAccessKeyFromArgs(args);
        String accessToken = getAccessTokenFromArgs(args);

        // Creating a name for the client
        final String destination = "democlient-" + UUID.randomUUID().toString();

        // Define connection to the Proteus Broker
        final Proteus proteus = Proteus.builder()
                .group("proteus.example.client")    // Name of this client's group
                .destination(destination)           // Name of this client
                .accessKey(accessKey)               // Access key for connecting to Proteus Broker
                .accessToken(accessToken)           // Access token for connecting to Proteus Broker
                .host("localhost")                  // Proteus Broker's host
                .port(8001)                         // Proteus Broker's port
                .build();

        // Create virtual connection to the VowelCount service group
        ProteusSocket conn = proteus.group("proteus.example.service.vowelcount");

        CountDownLatch latch = new CountDownLatch(100);

        // Send a stream of random strings, load-balanced across all instances, to VowelCount service for processing.
        VowelCountServiceClient client = new VowelCountServiceClient(conn);
        client.countVowels(s -> s.onSubscribe(new Subscription() {
            @Override
            public void request(long n) {
                for (int i = 1; i <= n; i++) {
                    VowelCountRequest request = VowelCountRequest.newBuilder()
                            .setMessage(RandomString.next(10, ThreadLocalRandom.current()))
                            .build();

                    s.onNext(request);
                }
            }

            @Override
            public void cancel() {
                // Aborting the latch early because the subscriber cancelled the request
                while(latch.getCount() > 0) {
                    latch.countDown();
                }
            }
        }))
        .onBackpressureDrop()
        .subscribe(response -> {
            // Receive response from vowelcount service with the total number of vowels counted
            System.out.println("Total Vowels Counted: " + response.getVowelCnt());
            latch.countDown();
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
