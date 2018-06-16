package proteus.example.service.vowelcount;

/**
 */
@javax.annotation.Generated(
    value = "by Proteus proto compiler (version 0.7.1)",
    comments = "Source: vowelcount.proto")
public interface VowelCountService {
  int NAMESPACE_ID = 962245336;
  int SERVICE_ID = 1528059860;
  int METHOD_COUNT_VOWELS = 1557158618;

  /**
   */
  reactor.core.publisher.Flux<proteus.example.service.vowelcount.VowelCountResponse> countVowels(org.reactivestreams.Publisher<proteus.example.service.vowelcount.VowelCountRequest> messages, io.netty.buffer.ByteBuf metadata);
}
