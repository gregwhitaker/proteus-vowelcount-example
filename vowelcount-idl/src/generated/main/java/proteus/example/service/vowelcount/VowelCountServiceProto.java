// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: vowelcount.proto

package proteus.example.service.vowelcount;

public final class VowelCountServiceProto {
  private VowelCountServiceProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proteus_example_service_vowelcount_VowelCountRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proteus_example_service_vowelcount_VowelCountRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_proteus_example_service_vowelcount_VowelCountResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_proteus_example_service_vowelcount_VowelCountResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020vowelcount.proto\022\"proteus.example.serv" +
      "ice.vowelcount\"$\n\021VowelCountRequest\022\017\n\007m" +
      "essage\030\001 \001(\t\"&\n\022VowelCountResponse\022\020\n\010vo" +
      "welCnt\030\001 \001(\0032\230\001\n\021VowelCountService\022\202\001\n\013C" +
      "ountVowels\0225.proteus.example.service.vow" +
      "elcount.VowelCountRequest\0326.proteus.exam" +
      "ple.service.vowelcount.VowelCountRespons" +
      "e\"\000(\0010\001B>\n\"proteus.example.service.vowel" +
      "countB\026VowelCountServiceProtoP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_proteus_example_service_vowelcount_VowelCountRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_proteus_example_service_vowelcount_VowelCountRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proteus_example_service_vowelcount_VowelCountRequest_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_proteus_example_service_vowelcount_VowelCountResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_proteus_example_service_vowelcount_VowelCountResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_proteus_example_service_vowelcount_VowelCountResponse_descriptor,
        new java.lang.String[] { "VowelCnt", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}