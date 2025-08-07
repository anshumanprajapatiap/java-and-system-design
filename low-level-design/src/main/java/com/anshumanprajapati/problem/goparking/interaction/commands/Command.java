package com.anshumanprajapati.problem.goparking.interaction.commands;


import com.anshumanprajapati.problem.goparking.exceptions.InvalidParameterException;

public interface Command {
    String helpText();
    void execute(String[] params) throws InvalidParameterException;
}
