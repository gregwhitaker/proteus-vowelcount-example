package proteus.example.service.vowelcount;

/**
 */
@javax.annotation.Generated(
    value = "by Proteus proto compiler (version 0.7.13)",
    comments = "Source: vowelcount.proto")
public interface VowelCountService {
  String SERVICE = "proteus.example.service.vowelcount.VowelCountService";
  String METHOD_COUNT_VOWELS = "CountVowels";

  /**
   */
  reactor.core.publisher.Flux<proteus.example.service.vowelcount.VowelCountResponse> countVowels(org.reactivestreams.Publisher<proteus.example.service.vowelcount.VowelCountRequest> messages, io.netty.buffer.ByteBuf metadata);
}
