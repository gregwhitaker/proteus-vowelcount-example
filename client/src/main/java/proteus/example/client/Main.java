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
import proteus.example.service.vowelcount.VowelCountServiceClient;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;

/**
 * Client that sends random strings to the VowelCount service to have the number
 * of vowels in the string tallied.
 */
public class Main {

    public static void main(String... args) throws Exception {
        // Creating a name for the client
        final String destination = "democlient-" + UUID.randomUUID().toString();

        // Define connection to the Proteus Broker
        final Proteus proteus = Proteus.builder()
                .group("proteus.example.client")    // Name of this client's group
                .destination(destination)           // Name of this client
                .accessKey(7685465987873703191L)    // Access key for connecting to Proteus Broker
                .accessToken("")                    // Access token for connecting to Proteus Broker
                .host("localhost")                  // Proteus Broker's host
                .port(8001)                         // Proteus Broker's port
                .build();

        ProteusSocket conn = proteus.group("proteus.example.service.vowelcount");

        CountDownLatch latch = new CountDownLatch(100);

        // Send a stream of random strings, load-balanced across all instances, to VowelCount service for processing.
        VowelCountServiceClient client = new VowelCountServiceClient(conn);
        client.countVowels(s -> s.onSubscribe(new Subscription() {
            @Override
            public void request(long n) {
                VowelCountRequest request = VowelCountRequest.newBuilder()
                        .setMessage(RandomString.nextString())
                        .build();

                s.onNext(request);
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
        .doOnNext(response -> {
            // Receive response from vowelcount service with the total number of vowels counted
            System.out.println("Total Vowels Counted: " + response.getVowelCnt());
            latch.countDown();
        })
        .subscribe();

        latch.await();
    }
}
