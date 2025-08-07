package com.anshumanprajapati.problem.bookmyshow.client;

import com.anshumanprajapati.problem.bookmyshow.exception.CommandNotFoundException;
import com.anshumanprajapati.problem.bookmyshow.exception.InvalidParameterException;
import com.anshumanprajapati.problem.bookmyshow.interaction.CommandFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public abstract class Client {

    BufferedReader inputReader;
    CommandFactory commandFactory;

    Client(BufferedReader inputReader, CommandFactory commandFactory){
        this.inputReader = inputReader;
        this.commandFactory = commandFactory;
    }

    public void handleInput() throws IOException {
        try {
            while (true) {
                String inputLine = this.inputReader.readLine();
                if (inputLine == null) {
                    break;
                }

                inputLine = inputLine.trim();
                if (inputLine.isEmpty()) {
                    continue;
                }

                if (inputLine.equalsIgnoreCase("exit")) {
                    break;
                }

                processInputLine(inputLine);
            }
        } finally {
            inputReader.close();
        }
    }
    public void  processInputLine(String inputLine){
        String[] inputChunks = inputLine.split(" ");

        String command = inputChunks[0];
        String[] params = Arrays.copyOfRange(
                inputChunks,
                1,
                inputChunks.length
        );

        try {
            commandFactory.executeCommand(command, params);
        } catch (CommandNotFoundException | InvalidParameterException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
