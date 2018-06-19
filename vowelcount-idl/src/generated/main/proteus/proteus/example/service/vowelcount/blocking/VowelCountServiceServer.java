package proteus.example.service.vowelcount.blocking;

@javax.annotation.Generated(
    value = "by Proteus proto compiler (version 0.7.13)",
    comments = "Source: vowelcount.proto")
public final class VowelCountServiceServer extends io.netifi.proteus.AbstractProteusService {
  private final VowelCountService service;
  private final reactor.core.scheduler.Scheduler scheduler;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<io.rsocket.Payload>, ? extends org.reactivestreams.Publisher<io.rsocket.Payload>> countVowels;

  public VowelCountServiceServer(VowelCountService service, reactor.core.scheduler.Scheduler scheduler) {
    this.scheduler = scheduler;
    this.service = service;
    this.countVowels = java.util.function.Function.identity();
  }


  public VowelCountServiceServer(VowelCountService service) {
    this.scheduler = reactor.core.scheduler.Schedulers.elastic();
    this.service = service;
    this.countVowels = java.util.function.Function.identity();
  }

  public VowelCountServiceServer(VowelCountService service, io.micrometer.core.instrument.MeterRegistry registry) {
    this.scheduler = reactor.core.scheduler.Schedulers.elastic();
    this.service = service;
    this.countVowels = io.netifi.proteus.metrics.ProteusMetrics.timed(registry, "proteus.server", "namespace", "proteus.example.service.vowelcount.blocking", "service", "VowelCountService", "method", "countVowels");
  }

  public VowelCountServiceServer(VowelCountService service, reactor.core.scheduler.Scheduler scheduler, io.micrometer.core.instrument.MeterRegistry registry) {
    this.scheduler = scheduler;
    this.service = service;
    this.countVowels = io.netifi.proteus.metrics.ProteusMetrics.timed(registry, "proteus.server", "namespace", "proteus.example.service.vowelcount.blocking", "service", "VowelCountService", "method", "countVowels");
  }

  @java.lang.Override
  public String getService() {
    return VowelCountService.SERVICE_ID;
  }

  @java.lang.Override
  public reactor.core.publisher.Mono<Void> fireAndForget(io.rsocket.Payload payload) {
    return reactor.core.publisher.Mono.error(new UnsupportedOperationException("Fire and forget not implemented."));
  }

  @java.lang.Override
  public reactor.core.publisher.Mono<io.rsocket.Payload> requestResponse(io.rsocket.Payload payload) {
    return reactor.core.publisher.Mono.error(new UnsupportedOperationException("Request-Response not implemented."));
  }

  @java.lang.Override
  public reactor.core.publisher.Flux<io.rsocket.Payload> requestStream(io.rsocket.Payload payload) {
    return reactor.core.publisher.Flux.error(new UnsupportedOperationException("Request-Stream not implemented."));
  }

  @java.lang.Override
  public reactor.core.publisher.Flux<io.rsocket.Payload> requestChannel(io.rsocket.Payload payload, reactor.core.publisher.Flux<io.rsocket.Payload> publisher) {
    try {
      io.netty.buffer.ByteBuf metadata = payload.sliceMetadata();
      switch(io.netifi.proteus.frames.ProteusMetadata.getMethod(metadata)) {
        case VowelCountService.METHOD_COUNT_VOWELS: {
          reactor.core.publisher.Flux<proteus.example.service.vowelcount.VowelCountRequest> messages =
            publisher.map(deserializer(proteus.example.service.vowelcount.VowelCountRequest.parser()));
          return reactor.core.publisher.Flux.defer(() -> reactor.core.publisher.Flux.fromIterable(service.countVowels(messages.toIterable(), metadata)).map(serializer).transform(countVowels)).subscribeOn(scheduler);
        }
        default: {
          return reactor.core.publisher.Flux.error(new UnsupportedOperationException());
        }
      }
    } catch (Throwable t) {
      return reactor.core.publisher.Flux.error(t);
    }
  }

  @java.lang.Override
  public reactor.core.publisher.Flux<io.rsocket.Payload> requestChannel(org.reactivestreams.Publisher<io.rsocket.Payload> payloads) {
    return new io.rsocket.internal.SwitchTransform<io.rsocket.Payload, io.rsocket.Payload>(payloads, new java.util.function.BiFunction<io.rsocket.Payload, reactor.core.publisher.Flux<io.rsocket.Payload>, org.reactivestreams.Publisher<? extends io.rsocket.Payload>>() {
      @java.lang.Override
      public org.reactivestreams.Publisher<io.rsocket.Payload> apply(io.rsocket.Payload payload, reactor.core.publisher.Flux<io.rsocket.Payload> publisher) {
        return requestChannel(payload, publisher);
      }
    });
  }

  private static final java.util.function.Function<com.google.protobuf.MessageLite, io.rsocket.Payload> serializer =
    new java.util.function.Function<com.google.protobuf.MessageLite, io.rsocket.Payload>() {
      @java.lang.Override
      public io.rsocket.Payload apply(com.google.protobuf.MessageLite message) {
        int length = message.getSerializedSize();
        io.netty.buffer.ByteBuf byteBuf = io.netty.buffer.ByteBufAllocator.DEFAULT.buffer(length);
        try {
          message.writeTo(com.google.protobuf.CodedOutputStream.newInstance(byteBuf.internalNioBuffer(0, length)));
          byteBuf.writerIndex(length);
          return io.rsocket.util.ByteBufPayload.create(byteBuf);
        } catch (Throwable t) {
          byteBuf.release();
          throw new RuntimeException(t);
        }
      }
    };

  private static <T> java.util.function.Function<io.rsocket.Payload, T> deserializer(final com.google.protobuf.Parser<T> parser) {
    return new java.util.function.Function<io.rsocket.Payload, T>() {
      @java.lang.Override
      public T apply(io.rsocket.Payload payload) {
        try {
          com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(payload.getData());
          return parser.parseFrom(is);
        } catch (Throwable t) {
          throw new RuntimeException(t);
        } finally {
          payload.release();
        }
      }
    };
  }
}
