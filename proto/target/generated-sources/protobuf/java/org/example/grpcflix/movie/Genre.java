// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: common/common.proto

package org.example.grpcflix.movie;

/**
 * Protobuf enum {@code Genre}
 */
public enum Genre
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>DRAMA = 0;</code>
   */
  DRAMA(0),
  /**
   * <code>ACTION = 1;</code>
   */
  ACTION(1),
  /**
   * <code>CRIME = 2;</code>
   */
  CRIME(2),
  /**
   * <code>WESTERN = 3;</code>
   */
  WESTERN(3),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>DRAMA = 0;</code>
   */
  public static final int DRAMA_VALUE = 0;
  /**
   * <code>ACTION = 1;</code>
   */
  public static final int ACTION_VALUE = 1;
  /**
   * <code>CRIME = 2;</code>
   */
  public static final int CRIME_VALUE = 2;
  /**
   * <code>WESTERN = 3;</code>
   */
  public static final int WESTERN_VALUE = 3;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static Genre valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static Genre forNumber(int value) {
    switch (value) {
      case 0: return DRAMA;
      case 1: return ACTION;
      case 2: return CRIME;
      case 3: return WESTERN;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<Genre>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      Genre> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<Genre>() {
          public Genre findValueByNumber(int number) {
            return Genre.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return org.example.grpcflix.movie.Common.getDescriptor().getEnumTypes().get(0);
  }

  private static final Genre[] VALUES = values();

  public static Genre valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private Genre(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:Genre)
}

