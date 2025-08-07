package com.anshumanprajapati.problem.bookmyshow.client;


import com.anshumanprajapati.problem.bookmyshow.interaction.CommandFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class ClientFactory {

    public Client buildClient(String[] args, CommandFactory commandFactory) throws FileNotFoundException {

        if(args.length==0){
            return new CLIClient( new BufferedReader(new InputStreamReader(System.in)), commandFactory);
        }else{
            return new FileClient(new BufferedReader(new FileReader(args[0])), commandFactory);
        }
    }
}
