package com.zhongjis.versioncheck.controller.exception;

public class IlegalVersionIdException extends Exception {

  public IlegalVersionIdException(String message) {
    super(message);
  }

  public IlegalVersionIdException(String message, Throwable cause) {
    super(message, cause);
  }
}
