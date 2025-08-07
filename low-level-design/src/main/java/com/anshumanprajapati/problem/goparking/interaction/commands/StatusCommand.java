package com.anshumanprajapati.problem.goparking.interaction.commands;

import com.anshumanprajapati.problem.goparking.exceptions.InvalidParameterException;
import com.anshumanprajapati.problem.goparking.handler.ParkingLotCommandHandler;

public class StatusCommand implements Command {

    private ParkingLotCommandHandler parkingLotCommandHandler;

    public StatusCommand(ParkingLotCommandHandler parkingLotCommandHandler) {
        this.parkingLotCommandHandler = parkingLotCommandHandler;
    }

    @Override
    public String helpText() {
        return "status";
    }

    @Override
    public void execute(String[] params) throws InvalidParameterException {
        this.parkingLotCommandHandler.status();
    }
}
