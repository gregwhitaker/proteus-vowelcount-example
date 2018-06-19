package proteus.example.service.vowelcount.blocking;

/**
 */
@javax.annotation.Generated(
    value = "by Proteus proto compiler (version 0.7.13)",
    comments = "Source: vowelcount.proto")
public interface VowelCountService {
  String SERVICE_ID = "proteus.example.service.vowelcountVowelCountService";
  String METHOD_COUNT_VOWELS = "CountVowels";

  /**
   */
  Iterable<proteus.example.service.vowelcount.VowelCountResponse> countVowels(Iterable<proteus.example.service.vowelcount.VowelCountRequest> messages, io.netty.buffer.ByteBuf metadata);
}
