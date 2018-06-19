package proteus.example.service.isvowel.blocking;

@javax.annotation.Generated(
    value = "by Proteus proto compiler (version 0.7.13)",
    comments = "Source: isvowel.proto")
public final class IsVowelServiceClient implements IsVowelService {
  private final proteus.example.service.isvowel.IsVowelServiceClient delegate;

  public IsVowelServiceClient(io.rsocket.RSocket rSocket) {
    this.delegate = new proteus.example.service.isvowel.IsVowelServiceClient(rSocket);
  }

  public IsVowelServiceClient(io.rsocket.RSocket rSocket, io.micrometer.core.instrument.MeterRegistry registry) {
    this.delegate = new proteus.example.service.isvowel.IsVowelServiceClient(rSocket, registry);
  }

  public proteus.example.service.isvowel.IsVowelResponse isVowel(proteus.example.service.isvowel.IsVowelRequest message) {
    return isVowel(message, io.netty.buffer.Unpooled.EMPTY_BUFFER);
  }

  @java.lang.Override
  public proteus.example.service.isvowel.IsVowelResponse isVowel(proteus.example.service.isvowel.IsVowelRequest message, io.netty.buffer.ByteBuf metadata) {
    return delegate.isVowel(message, metadata).block();
  }

}

