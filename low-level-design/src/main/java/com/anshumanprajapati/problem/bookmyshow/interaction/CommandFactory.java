package com.anshumanprajapati.problem.bookmyshow.interaction;


import com.anshumanprajapati.problem.bookmyshow.exception.CommandNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    Map<String, Command> commandMap;

    CommandFactory(){
        this.commandMap = new HashMap<>();
    }


    public void executeCommand(String name, String[] args) throws CommandNotFoundException {
        if(commandMap.containsKey(name)){
            System.out.println(name + args);
        }else{
            throw new CommandNotFoundException(name);
        }
    }
}
