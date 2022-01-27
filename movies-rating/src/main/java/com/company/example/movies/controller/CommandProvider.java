package com.company.example.movies.controller;

import com.company.example.movies.controller.impl.*;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {

    private final Map<String, Command> commands = new HashMap<String, Command>();

    public CommandProvider() {
        commands.put("authorization", new AuthorizationCommand());
        commands.put("registration", new RegistrationCommand());
        commands.put("goToRegistrationPage", new GoToRegistrationPage());
        commands.put("goToMainPage", new GoToMainPage());
        commands.put("goToAuthorizationPage", new GoToAuthorizationPage());
        commands.put("goToAdministratorPage", new GoToAdministratorPage());
        commands.put("endSession", new EndSessionCommand());
        commands.put("goToErrorPage", new EndSessionCommand());
    }

    public final Command getCommand(String commandName) {
        Command command = commands.get(commandName);
        return command;
    }

}
