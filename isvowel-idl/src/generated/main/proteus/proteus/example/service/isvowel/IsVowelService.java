package proteus.example.service.isvowel;

/**
 */
@javax.annotation.Generated(
    value = "by Proteus proto compiler (version 0.7.1)",
    comments = "Source: isvowel.proto")
public interface IsVowelService {
  int NAMESPACE_ID = -745758071;
  int SERVICE_ID = -122448787;
  int METHOD_IS_VOWEL = 805157322;

  /**
   */
  reactor.core.publisher.Mono<proteus.example.service.isvowel.IsVowelResponse> isVowel(proteus.example.service.isvowel.IsVowelRequest message, io.netty.buffer.ByteBuf metadata);
}
