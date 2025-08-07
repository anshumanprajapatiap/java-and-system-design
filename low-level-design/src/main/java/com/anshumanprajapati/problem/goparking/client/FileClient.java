package com.anshumanprajapati.problem.goparking.client;

import com.anshumanprajapati.problem.goparking.interaction.CommandFactory;
import java.io.BufferedReader;

public class FileClient extends Client {

    public FileClient(
        BufferedReader inputReader,
        CommandFactory commandFactory
    ) {
        super(inputReader, commandFactory);
    }
}
