package com.company.example.movies.controller.impl;

import com.company.example.movies.controller.Command;
import com.company.example.movies.controller.ControllerException;
import com.company.example.movies.entity.Movie;
import com.company.example.movies.entity.User;
import com.company.example.movies.service.ServiceException;
import com.company.example.movies.service.ServiceFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoToAdministratorPage implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ControllerException {
        List<User> users;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        try {

            users = serviceFactory.getUserService().users();
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }

        request.setAttribute("users", users);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/administratorPage.jsp");
        dispatcher.forward(request, response);
    }
}
