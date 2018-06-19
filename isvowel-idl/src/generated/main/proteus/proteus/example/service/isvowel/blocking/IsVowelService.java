package proteus.example.service.isvowel.blocking;

/**
 */
@javax.annotation.Generated(
    value = "by Proteus proto compiler (version 0.7.13)",
    comments = "Source: isvowel.proto")
public interface IsVowelService {
  String SERVICE_ID = "proteus.example.service.isvowelIsVowelService";
  String METHOD_IS_VOWEL = "IsVowel";

  /**
   */
  proteus.example.service.isvowel.IsVowelResponse isVowel(proteus.example.service.isvowel.IsVowelRequest message, io.netty.buffer.ByteBuf metadata);
}
