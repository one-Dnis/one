package com.company.example.movies.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {

    private final CommandProvider provider = new CommandProvider();

    public Controller() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        //super.doGet(request, response);
        process(request, response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        //super.doPost(request, response);
        process(request, response);

    }

    private void process(HttpServletRequest request, HttpServletResponse response) {

        String commandName = request.getParameter("command");

        Command command = provider.getCommand(commandName);
        command.execute(request, response);




    }
}
