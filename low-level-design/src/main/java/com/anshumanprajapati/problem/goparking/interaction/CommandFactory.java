package com.anshumanprajapati.problem.goparking.interaction;


import com.anshumanprajapati.problem.goparking.exceptions.CommandNotFoundException;
import com.anshumanprajapati.problem.goparking.exceptions.InvalidParameterException;
import com.anshumanprajapati.problem.goparking.handler.ParkingLotCommandHandler;
import com.anshumanprajapati.problem.goparking.interaction.commands.Command;
import com.anshumanprajapati.problem.goparking.interaction.commands.CreateLotCommand;
import com.anshumanprajapati.problem.goparking.interaction.commands.ParkCommand;
import com.anshumanprajapati.problem.goparking.interaction.commands.StatusCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private Map<String, Command> commands;

    private CommandFactory() {
        commands = new HashMap<>();
    }

    public static CommandFactory init(
        ParkingLotCommandHandler parkingLotCommandHandler
    ) {
        final CommandFactory cf = new CommandFactory();

        cf.addCommand(
            "create_parking_lot",
            new CreateLotCommand(parkingLotCommandHandler)
        );
        cf.addCommand("park", new ParkCommand(parkingLotCommandHandler));
        cf.addCommand("status", new StatusCommand(parkingLotCommandHandler));

        return cf;
    }

    public void addCommand(String name, Command command) {
        commands.put(name, command);
    }

    public void executeCommand(String name, String[] params)
        throws CommandNotFoundException, InvalidParameterException {
        if (commands.containsKey(name)) {
            commands.get(name).execute(params);
        } else {
            throw new CommandNotFoundException(name);
        }
    }

    public void listCommandHelp() {
        commands
            .keySet()
            .stream()
            .map(command -> commands.get(command).helpText())
            .forEach(System.out::println);
    }

    public Map<String, Command> getCommands() {
        return commands;
    }
}
