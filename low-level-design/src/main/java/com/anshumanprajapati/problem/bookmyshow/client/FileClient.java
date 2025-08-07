package com.anshumanprajapati.problem.bookmyshow.client;

import com.anshumanprajapati.problem.bookmyshow.interaction.CommandFactory;

import java.io.BufferedReader;

public class FileClient extends Client{

    FileClient(BufferedReader inputReader, CommandFactory commandFactory) {
        super(inputReader, commandFactory);
    }
}
