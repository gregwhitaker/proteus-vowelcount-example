package proteus.example.service.isvowel;

/**
 */
@javax.annotation.Generated(
    value = "by Proteus proto compiler (version 0.7.13)",
    comments = "Source: isvowel.proto")
public interface IsVowelService {
  String SERVICE = "proteus.example.service.isvowel.IsVowelService";
  String METHOD_IS_VOWEL = "IsVowel";

  /**
   */
  reactor.core.publisher.Mono<proteus.example.service.isvowel.IsVowelResponse> isVowel(proteus.example.service.isvowel.IsVowelRequest message, io.netty.buffer.ByteBuf metadata);
}
