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

import io.netty.buffer.ByteBuf;
import javafx.geometry.VPos;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Signal;
import reactor.core.publisher.SignalType;
import reactor.util.context.Context;

import java.util.HashSet;
import java.util.Set;

public class DefaultIsVowelService implements IsVowelService {

    private final Set<String> VOWELS = new HashSet<>();

    public DefaultIsVowelService() {
        VOWELS.add("A");
        VOWELS.add("E");
        VOWELS.add("I");
        VOWELS.add("O");
        VOWELS.add("U");
    }

    @Override
    public Mono<IsVowelResponse> isVowel(IsVowelRequest message, ByteBuf metadata) {
        return Mono.create(isVowelResponseMonoSink -> {
            IsVowelResponse response = IsVowelResponse.newBuilder()
                    .setIsVowel(VOWELS.contains(message.getCharacter()))
                    .build();

            isVowelResponseMonoSink.success(response);
        });
    }
}
