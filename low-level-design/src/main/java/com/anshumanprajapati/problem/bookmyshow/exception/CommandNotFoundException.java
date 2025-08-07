package com.anshumanprajapati.problem.bookmyshow.exception;

public class CommandNotFoundException extends RuntimeException {
  public CommandNotFoundException(String message) {
    super(message);
  }
}
