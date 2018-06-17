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
package proteus.example.service.isvowel;

import io.netifi.proteus.Proteus;

import java.util.UUID;

public class Main {

    public static void main(String... args) throws Exception {
        // Creating a name for the service
        final String destination = "isvowel-" + UUID.randomUUID().toString();

        // Define connection to the Proteus Broker
        final Proteus proteus = Proteus.builder()
                .group("proteus.example.service.isvowel")   // Name of this service's group
                .destination(destination)                   // Name of this service instance
                .accessKey(7685465987873703191L)            // Access key for connecting to Proteus Broker
                .accessToken("")                            // Access token for connecting to Proteus Broker
                .host("localhost")                          // Proteus Broker's host
                .port(8001)                                 // Proteus Broker's port
                .build();

        // Start the IsVowel Service
        proteus.addService(new IsVowelServiceServer(new DefaultIsVowelService()));

        Thread.currentThread().join();
    }
}
