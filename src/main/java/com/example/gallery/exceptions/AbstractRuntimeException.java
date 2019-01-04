package com.example.gallery.exceptions;

abstract class AbstractRuntimeException extends RuntimeException {

  private String code;

  AbstractRuntimeException(String message, String code) {
    super(message);
    this.code = code;
  }

  AbstractRuntimeException(String message, Throwable cause, String code) {
    super(message, cause);
    this.code = code;
  }

  String getCode() {
    return code;
  }
}