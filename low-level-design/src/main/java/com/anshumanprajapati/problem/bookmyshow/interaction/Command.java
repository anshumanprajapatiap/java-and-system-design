package com.anshumanprajapati.problem.bookmyshow.interaction;

import com.anshumanprajapati.problem.bookmyshow.exception.InvalidParameterException;

public interface Command {

    String help();
    void execute(String[] params) throws InvalidParameterException;
}
