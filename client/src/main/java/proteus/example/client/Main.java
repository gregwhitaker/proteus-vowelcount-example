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

import com.google.protobuf.InvalidProtocolBufferException;
import io.netifi.proteus.Proteus;
import org.reactivestreams.Subscription;
import proteus.example.service.vowelcount.VowelCountResponse;

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

        CountDownLatch latch = new CountDownLatch(100);

        // Stream random strings to the vowelcount service for processing
        proteus.group("proteus.example.service.vowelcount")
                .requestChannel(s -> s.onSubscribe(new Subscription() {
                    @Override
                    public void request(long n) {

                    }

                    @Override
                    public void cancel() {

                    }
                }))
                .onBackpressureDrop()
                .doOnNext(payload -> {
                    // Receive response from vowelcount service with the total number of vowels counted
                    try {
                        VowelCountResponse response = VowelCountResponse.parseFrom(payload.getData());
                        System.out.println("Total Vowels Counted: " + response.getVowelCnt());
                    } catch (InvalidProtocolBufferException e) {
                        e.printStackTrace();
                    } finally {
                        latch.countDown();
                    }
                })
                .subscribe();

        latch.await();
    }
}
