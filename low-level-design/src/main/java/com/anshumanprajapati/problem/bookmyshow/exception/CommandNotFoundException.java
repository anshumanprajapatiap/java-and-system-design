package com.anshumanprajapati.problem.bookmyshow.exception;

public class CommandNotFoundException extends Exception {
  private String name;

  public CommandNotFoundException(String name) {
    this.name = name;
  }

  @Override
  public String getMessage() {
    return "Command " + name + " not found";
  }
}
