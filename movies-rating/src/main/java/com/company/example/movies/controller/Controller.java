package com.company.example.movies.controller;

import com.company.example.movies.dao.DAOException;
import com.company.example.movies.dao.connectionpool.ConnectionPoolException;
import com.company.example.movies.service.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class Controller extends HttpServlet {

    private final CommandProvider provider = new CommandProvider();

    public Controller() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,  IOException {
        //super.doGet(req, resp);
        try {
            process(request, response);
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (ControllerException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.doPost(req, resp);
        /*try {
            process(request, response);
        } catch (DAOException e) {
            e.printStackTrace();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException, ControllerException {

        String commandName = request.getParameter("command");

        Command command = provider.getCommand(commandName);
        command.execute(request, response);


    }
}
