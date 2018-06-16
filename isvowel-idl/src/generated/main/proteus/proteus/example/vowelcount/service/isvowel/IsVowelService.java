package proteus.example.vowelcount.service.isvowel;

/**
 */
@javax.annotation.Generated(
    value = "by Proteus proto compiler (version 0.7.1)",
    comments = "Source: isvowel.proto")
public interface IsVowelService {
  int NAMESPACE_ID = 204814325;
  int SERVICE_ID = -122448787;
  int METHOD_IS_VOWEL = -1302047162;

  /**
   */
  reactor.core.publisher.Mono<proteus.example.vowelcount.service.isvowel.IsVowelResponse> isVowel(proteus.example.vowelcount.service.isvowel.IsVowelRequest message, io.netty.buffer.ByteBuf metadata);
}
