package proteus.example.service.isvowel;

@javax.annotation.Generated(
    value = "by Proteus proto compiler (version 0.7.13)",
    comments = "Source: isvowel.proto")
public final class IsVowelServiceClient implements IsVowelService {
  private final io.rsocket.RSocket rSocket;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<proteus.example.service.isvowel.IsVowelResponse>, ? extends org.reactivestreams.Publisher<proteus.example.service.isvowel.IsVowelResponse>> isVowel;

  public IsVowelServiceClient(io.rsocket.RSocket rSocket) {
    this.rSocket = rSocket;
    this.isVowel = java.util.function.Function.identity();
  }

  public IsVowelServiceClient(io.rsocket.RSocket rSocket, io.micrometer.core.instrument.MeterRegistry registry) {
    this.rSocket = rSocket;
    this.isVowel = io.netifi.proteus.metrics.ProteusMetrics.timed(registry, "proteus.client", "service", IsVowelService.SERVICE, "method", IsVowelService.METHOD_IS_VOWEL);
  }

  public reactor.core.publisher.Mono<proteus.example.service.isvowel.IsVowelResponse> isVowel(proteus.example.service.isvowel.IsVowelRequest message) {
    return isVowel(message, io.netty.buffer.Unpooled.EMPTY_BUFFER);
  }

  @java.lang.Override
  public reactor.core.publisher.Mono<proteus.example.service.isvowel.IsVowelResponse> isVowel(proteus.example.service.isvowel.IsVowelRequest message, io.netty.buffer.ByteBuf metadata) {
    return reactor.core.publisher.Mono.defer(new java.util.function.Supplier<reactor.core.publisher.Mono<io.rsocket.Payload>>() {
      @java.lang.Override
      public reactor.core.publisher.Mono<io.rsocket.Payload> get() {
        final io.netty.buffer.ByteBuf metadataBuf = io.netifi.proteus.frames.ProteusMetadata.encode(io.netty.buffer.ByteBufAllocator.DEFAULT, IsVowelService.SERVICE, IsVowelService.METHOD_IS_VOWEL, metadata);
        io.netty.buffer.ByteBuf data = serialize(message);
        return rSocket.requestResponse(io.rsocket.util.ByteBufPayload.create(data, metadataBuf));
      }
    }).map(deserializer(proteus.example.service.isvowel.IsVowelResponse.parser())).transform(isVowel);
  }

  private static io.netty.buffer.ByteBuf serialize(final com.google.protobuf.MessageLite message) {
    int length = message.getSerializedSize();
    io.netty.buffer.ByteBuf byteBuf = io.netty.buffer.ByteBufAllocator.DEFAULT.buffer(length);
    try {
      message.writeTo(com.google.protobuf.CodedOutputStream.newInstance(byteBuf.internalNioBuffer(0, length)));
      byteBuf.writerIndex(length);
      return byteBuf;
    } catch (Throwable t) {
      byteBuf.release();
      throw new RuntimeException(t);
    }
  }

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
