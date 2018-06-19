package proteus.example.service.isvowel.blocking;

@javax.annotation.Generated(
    value = "by Proteus proto compiler (version 0.7.13)",
    comments = "Source: isvowel.proto")
public final class IsVowelServiceServer extends io.netifi.proteus.AbstractProteusService {
  private final IsVowelService service;
  private final reactor.core.scheduler.Scheduler scheduler;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<io.rsocket.Payload>, ? extends org.reactivestreams.Publisher<io.rsocket.Payload>> isVowel;

  public IsVowelServiceServer(IsVowelService service, reactor.core.scheduler.Scheduler scheduler) {
    this.scheduler = scheduler;
    this.service = service;
    this.isVowel = java.util.function.Function.identity();
  }


  public IsVowelServiceServer(IsVowelService service) {
    this.scheduler = reactor.core.scheduler.Schedulers.elastic();
    this.service = service;
    this.isVowel = java.util.function.Function.identity();
  }

  public IsVowelServiceServer(IsVowelService service, io.micrometer.core.instrument.MeterRegistry registry) {
    this.scheduler = reactor.core.scheduler.Schedulers.elastic();
    this.service = service;
    this.isVowel = io.netifi.proteus.metrics.ProteusMetrics.timed(registry, "proteus.server", "namespace", "proteus.example.service.isvowel.blocking", "service", "IsVowelService", "method", "isVowel");
  }

  public IsVowelServiceServer(IsVowelService service, reactor.core.scheduler.Scheduler scheduler, io.micrometer.core.instrument.MeterRegistry registry) {
    this.scheduler = scheduler;
    this.service = service;
    this.isVowel = io.netifi.proteus.metrics.ProteusMetrics.timed(registry, "proteus.server", "namespace", "proteus.example.service.isvowel.blocking", "service", "IsVowelService", "method", "isVowel");
  }

  @java.lang.Override
  public String getService() {
    return IsVowelService.SERVICE_ID;
  }

  @java.lang.Override
  public reactor.core.publisher.Mono<Void> fireAndForget(io.rsocket.Payload payload) {
    return reactor.core.publisher.Mono.error(new UnsupportedOperationException("Fire and forget not implemented."));
  }

  @java.lang.Override
  public reactor.core.publisher.Mono<io.rsocket.Payload> requestResponse(io.rsocket.Payload payload) {
    try {
      io.netty.buffer.ByteBuf metadata = payload.sliceMetadata();
      switch(io.netifi.proteus.frames.ProteusMetadata.getMethod(metadata)) {
        case IsVowelService.METHOD_IS_VOWEL: {
          com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(payload.getData());
          proteus.example.service.isvowel.IsVowelRequest message = proteus.example.service.isvowel.IsVowelRequest.parseFrom(is);
          return reactor.core.publisher.Mono.fromSupplier(() -> service.isVowel(message, metadata)).map(serializer).transform(isVowel).subscribeOn(scheduler);
        }
        default: {
          return reactor.core.publisher.Mono.error(new UnsupportedOperationException());
        }
      }
    } catch (Throwable t) {
      return reactor.core.publisher.Mono.error(t);
    } finally {
      payload.release();
    }
  }

  @java.lang.Override
  public reactor.core.publisher.Flux<io.rsocket.Payload> requestStream(io.rsocket.Payload payload) {
    return reactor.core.publisher.Flux.error(new UnsupportedOperationException("Request-Stream not implemented."));
  }

  @java.lang.Override
  public reactor.core.publisher.Flux<io.rsocket.Payload> requestChannel(io.rsocket.Payload payload, reactor.core.publisher.Flux<io.rsocket.Payload> publisher) {
    return reactor.core.publisher.Flux.error(new UnsupportedOperationException("Request-Channel not implemented."));
  }

  @java.lang.Override
  public reactor.core.publisher.Flux<io.rsocket.Payload> requestChannel(org.reactivestreams.Publisher<io.rsocket.Payload> payloads) {
    return reactor.core.publisher.Flux.error(new UnsupportedOperationException("Request-Channel not implemented."));
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