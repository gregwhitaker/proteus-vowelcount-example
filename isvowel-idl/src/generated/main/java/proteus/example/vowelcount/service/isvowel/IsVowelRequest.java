// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: isvowel.proto

package proteus.example.vowelcount.service.isvowel;

/**
 * Protobuf type {@code proteus.example.vowelcount.service.isvowel.IsVowelRequest}
 */
public  final class IsVowelRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:proteus.example.vowelcount.service.isvowel.IsVowelRequest)
    IsVowelRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use IsVowelRequest.newBuilder() to construct.
  private IsVowelRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private IsVowelRequest() {
    character_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private IsVowelRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            character_ = s;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return proteus.example.vowelcount.service.isvowel.IsVowelServiceProto.internal_static_proteus_example_vowelcount_service_isvowel_IsVowelRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return proteus.example.vowelcount.service.isvowel.IsVowelServiceProto.internal_static_proteus_example_vowelcount_service_isvowel_IsVowelRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            proteus.example.vowelcount.service.isvowel.IsVowelRequest.class, proteus.example.vowelcount.service.isvowel.IsVowelRequest.Builder.class);
  }

  public static final int CHARACTER_FIELD_NUMBER = 1;
  private volatile java.lang.Object character_;
  /**
   * <code>string character = 1;</code>
   */
  public java.lang.String getCharacter() {
    java.lang.Object ref = character_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      character_ = s;
      return s;
    }
  }
  /**
   * <code>string character = 1;</code>
   */
  public com.google.protobuf.ByteString
      getCharacterBytes() {
    java.lang.Object ref = character_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      character_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getCharacterBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, character_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getCharacterBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, character_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof proteus.example.vowelcount.service.isvowel.IsVowelRequest)) {
      return super.equals(obj);
    }
    proteus.example.vowelcount.service.isvowel.IsVowelRequest other = (proteus.example.vowelcount.service.isvowel.IsVowelRequest) obj;

    boolean result = true;
    result = result && getCharacter()
        .equals(other.getCharacter());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + CHARACTER_FIELD_NUMBER;
    hash = (53 * hash) + getCharacter().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static proteus.example.vowelcount.service.isvowel.IsVowelRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proteus.example.vowelcount.service.isvowel.IsVowelRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proteus.example.vowelcount.service.isvowel.IsVowelRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proteus.example.vowelcount.service.isvowel.IsVowelRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proteus.example.vowelcount.service.isvowel.IsVowelRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static proteus.example.vowelcount.service.isvowel.IsVowelRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static proteus.example.vowelcount.service.isvowel.IsVowelRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static proteus.example.vowelcount.service.isvowel.IsVowelRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static proteus.example.vowelcount.service.isvowel.IsVowelRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static proteus.example.vowelcount.service.isvowel.IsVowelRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static proteus.example.vowelcount.service.isvowel.IsVowelRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static proteus.example.vowelcount.service.isvowel.IsVowelRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(proteus.example.vowelcount.service.isvowel.IsVowelRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code proteus.example.vowelcount.service.isvowel.IsVowelRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:proteus.example.vowelcount.service.isvowel.IsVowelRequest)
      proteus.example.vowelcount.service.isvowel.IsVowelRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return proteus.example.vowelcount.service.isvowel.IsVowelServiceProto.internal_static_proteus_example_vowelcount_service_isvowel_IsVowelRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return proteus.example.vowelcount.service.isvowel.IsVowelServiceProto.internal_static_proteus_example_vowelcount_service_isvowel_IsVowelRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              proteus.example.vowelcount.service.isvowel.IsVowelRequest.class, proteus.example.vowelcount.service.isvowel.IsVowelRequest.Builder.class);
    }

    // Construct using proteus.example.vowelcount.service.isvowel.IsVowelRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      character_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return proteus.example.vowelcount.service.isvowel.IsVowelServiceProto.internal_static_proteus_example_vowelcount_service_isvowel_IsVowelRequest_descriptor;
    }

    public proteus.example.vowelcount.service.isvowel.IsVowelRequest getDefaultInstanceForType() {
      return proteus.example.vowelcount.service.isvowel.IsVowelRequest.getDefaultInstance();
    }

    public proteus.example.vowelcount.service.isvowel.IsVowelRequest build() {
      proteus.example.vowelcount.service.isvowel.IsVowelRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public proteus.example.vowelcount.service.isvowel.IsVowelRequest buildPartial() {
      proteus.example.vowelcount.service.isvowel.IsVowelRequest result = new proteus.example.vowelcount.service.isvowel.IsVowelRequest(this);
      result.character_ = character_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof proteus.example.vowelcount.service.isvowel.IsVowelRequest) {
        return mergeFrom((proteus.example.vowelcount.service.isvowel.IsVowelRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(proteus.example.vowelcount.service.isvowel.IsVowelRequest other) {
      if (other == proteus.example.vowelcount.service.isvowel.IsVowelRequest.getDefaultInstance()) return this;
      if (!other.getCharacter().isEmpty()) {
        character_ = other.character_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      proteus.example.vowelcount.service.isvowel.IsVowelRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (proteus.example.vowelcount.service.isvowel.IsVowelRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object character_ = "";
    /**
     * <code>string character = 1;</code>
     */
    public java.lang.String getCharacter() {
      java.lang.Object ref = character_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        character_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string character = 1;</code>
     */
    public com.google.protobuf.ByteString
        getCharacterBytes() {
      java.lang.Object ref = character_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        character_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string character = 1;</code>
     */
    public Builder setCharacter(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      character_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string character = 1;</code>
     */
    public Builder clearCharacter() {
      
      character_ = getDefaultInstance().getCharacter();
      onChanged();
      return this;
    }
    /**
     * <code>string character = 1;</code>
     */
    public Builder setCharacterBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      character_ = value;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:proteus.example.vowelcount.service.isvowel.IsVowelRequest)
  }

  // @@protoc_insertion_point(class_scope:proteus.example.vowelcount.service.isvowel.IsVowelRequest)
  private static final proteus.example.vowelcount.service.isvowel.IsVowelRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new proteus.example.vowelcount.service.isvowel.IsVowelRequest();
  }

  public static proteus.example.vowelcount.service.isvowel.IsVowelRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<IsVowelRequest>
      PARSER = new com.google.protobuf.AbstractParser<IsVowelRequest>() {
    public IsVowelRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new IsVowelRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<IsVowelRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<IsVowelRequest> getParserForType() {
    return PARSER;
  }

  public proteus.example.vowelcount.service.isvowel.IsVowelRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

