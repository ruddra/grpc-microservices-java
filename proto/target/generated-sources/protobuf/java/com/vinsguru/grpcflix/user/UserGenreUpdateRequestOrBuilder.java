// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: user-service.proto

package com.vinsguru.grpcflix.user;

public interface UserGenreUpdateRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:UserGenreUpdateRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string login_id = 1;</code>
   * @return The loginId.
   */
  java.lang.String getLoginId();
  /**
   * <code>string login_id = 1;</code>
   * @return The bytes for loginId.
   */
  com.google.protobuf.ByteString
      getLoginIdBytes();

  /**
   * <code>.Genre genre = 2;</code>
   * @return The enum numeric value on the wire for genre.
   */
  int getGenreValue();
  /**
   * <code>.Genre genre = 2;</code>
   * @return The genre.
   */
  com.vinsguru.grpcflix.movie.Genre getGenre();
}