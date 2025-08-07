package com.anshumanprajapati.problem.goparking.client;

import com.anshumanprajapati.problem.goparking.interaction.CommandFactory;
import java.io.BufferedReader;

public class CLIClient extends Client {

    public CLIClient(
        BufferedReader inputReader,
        CommandFactory commandFactory
    ) {
        super(inputReader, commandFactory);
    }
}
