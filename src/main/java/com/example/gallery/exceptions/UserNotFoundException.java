package com.example.gallery.exceptions;

public class UserNotFoundException extends AbstractRuntimeException {

  private static final String USER_NOT_FOUND = "USER_NOT_FOUND";

  public UserNotFoundException(String message) {
    super(message, USER_NOT_FOUND);
  }
}
