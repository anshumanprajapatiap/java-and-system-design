package com.anshumanprajapati.problem.bookmyshow.client;

import com.anshumanprajapati.problem.bookmyshow.interaction.CommandFactory;

import java.io.BufferedReader;

public class CLIClient  extends  Client{

    CLIClient(BufferedReader inputReader, CommandFactory commandFactory) {
        super(inputReader, commandFactory);
    }
}
