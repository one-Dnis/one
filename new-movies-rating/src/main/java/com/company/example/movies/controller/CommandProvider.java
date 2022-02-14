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
        //commands.put("goToErrorPage", new GoTo());
        commands.put("goToMoviePage", new GoToMoviePage());
        commands.put("goToReviewPage", new GoToReviewPage());
        commands.put("newReview", new ReviewCommand());
        commands.put("goToMessagePage", new GoToMessagePage());
        commands.put("goToNewMoviePage", new GoToNewMoviePage());
        commands.put("newMovie", new NewMovieCommand());
        commands.put("goToUserPage", new GoToUserPage());
        commands.put("banUser", new BanUserCommand());
        commands.put("unbanUser", new UnbanUserCommand());
        commands.put("locale", new LocaleCommand());
    }

    public final Command getCommand(String commandName) {
        Command command = commands.get(commandName);
        return command;
    }

}
