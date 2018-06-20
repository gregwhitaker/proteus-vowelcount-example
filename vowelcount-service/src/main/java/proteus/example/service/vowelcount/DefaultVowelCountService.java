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

import io.netifi.proteus.rsocket.ProteusSocket;
import io.netty.buffer.ByteBuf;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import proteus.example.service.isvowel.IsVowelRequest;
import proteus.example.service.isvowel.IsVowelResponse;
import proteus.example.service.isvowel.IsVowelServiceClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;

public class DefaultVowelCountService implements VowelCountService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultVowelCountService.class);

    private final AtomicLong totalVowels = new AtomicLong(0);
    private final IsVowelServiceClient isVowelClient;

    public DefaultVowelCountService(final ProteusSocket isVowelConn) {
        this.isVowelClient = new IsVowelServiceClient(isVowelConn);
    }
    
    @Override
    public Flux<VowelCountResponse> countVowels(Publisher<VowelCountRequest> messages, ByteBuf metadata) {
        return Flux.from(messages)
                .subscribeOn(Schedulers.elastic())
                // If client is sending more data than the service can handle buffer it
                .onBackpressureBuffer()
                // Split incoming message into stream of individual characters
                .flatMap(vowelCountRequest -> Flux.just(vowelCountRequest.getMessage().split("(?<!^)")))
                // Send each character to the IsVowel service for classification
                .flatMap((Function<String, Mono<? extends IsVowelResponse>>) s -> {
                    IsVowelRequest isVowelRequest = IsVowelRequest.newBuilder()
                            .setCharacter(s)
                            .build();

                    LOGGER.info("Sending character to IsVowel: {}", isVowelRequest.getCharacter());

                    return isVowelClient.isVowel(isVowelRequest);
                })
                // Increment vowel counter if vowel is found by IsVowel service
                .map(isVowelResponse -> {
                    if (isVowelResponse.getIsVowel()) {
                        LOGGER.info("Found vowel, incrementing total vowel count");
                        totalVowels.incrementAndGet();
                    }

                    return totalVowels.get();
                })
                .map(vcnt -> {
                    LOGGER.info("Sending total vowel count: {}", vcnt);

                    return VowelCountResponse.newBuilder()
                        .setVowelCnt(vcnt)
                        .build();
                });
    }
}
