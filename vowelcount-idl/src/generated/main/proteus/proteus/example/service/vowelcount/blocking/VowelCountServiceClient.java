package proteus.example.service.vowelcount.blocking;

@javax.annotation.Generated(
    value = "by Proteus proto compiler (version 0.7.13)",
    comments = "Source: vowelcount.proto")
public final class VowelCountServiceClient implements VowelCountService {
  private final proteus.example.service.vowelcount.VowelCountServiceClient delegate;

  public VowelCountServiceClient(io.rsocket.RSocket rSocket) {
    this.delegate = new proteus.example.service.vowelcount.VowelCountServiceClient(rSocket);
  }

  public VowelCountServiceClient(io.rsocket.RSocket rSocket, io.micrometer.core.instrument.MeterRegistry registry) {
    this.delegate = new proteus.example.service.vowelcount.VowelCountServiceClient(rSocket, registry);
  }

  public  io.netifi.proteus.BlockingIterable<proteus.example.service.vowelcount.VowelCountResponse> countVowels(Iterable<proteus.example.service.vowelcount.VowelCountRequest> messages) {
    return countVowels(messages, io.netty.buffer.Unpooled.EMPTY_BUFFER);
  }

  @java.lang.Override
  public  io.netifi.proteus.BlockingIterable<proteus.example.service.vowelcount.VowelCountResponse> countVowels(Iterable<proteus.example.service.vowelcount.VowelCountRequest> messages, io.netty.buffer.ByteBuf metadata) {
    reactor.core.publisher.Flux stream = delegate.countVowels(reactor.core.publisher.Flux.defer(() -> reactor.core.publisher.Flux.fromIterable(messages)), metadata);
    return new  io.netifi.proteus.BlockingIterable<>(stream, reactor.util.concurrent.Queues.SMALL_BUFFER_SIZE, reactor.util.concurrent.Queues.small());
  }

}

