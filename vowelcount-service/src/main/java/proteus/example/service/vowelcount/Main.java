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
package proteus.example.service.vowelcount;

import io.netifi.proteus.Proteus;
import io.netifi.proteus.rsocket.ProteusSocket;

import java.util.Optional;

public class Main {

    public static void main(String... args) throws Exception {
        Long accessKey = getAccessKeyFromArgs(args);
        String accessToken = getAccessTokenFromArgs(args);

        // Define connection to the Proteus Broker
        final Proteus proteus = Proteus.builder()
                .group("proteus.example.service.vowelcount")    // Name of this service's group
                .destination("vowelcount")                      // Name of this service instance
                .accessKey(accessKey)                           // Access key for connecting to the Proteus Broker
                .accessToken(accessToken)                       // Access token for connecting to the Proteus Broker
                .host("localhost")                              // Proteus Broker's host
                .port(8001)                                     // Proteus Broker's port
                .build();

        // Create virtual connection to the IsVowel service group
        ProteusSocket isVowelConn = proteus.group("proteus.example.service.isvowel");

        // Start the VowelCount Service
        proteus.addService(new VowelCountServiceServer(new DefaultVowelCountService(isVowelConn), Optional.empty()));

        Thread.currentThread().join();
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
