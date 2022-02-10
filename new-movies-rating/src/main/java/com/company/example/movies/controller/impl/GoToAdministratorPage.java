package com.company.example.movies.controller.impl;

import com.company.example.movies.controller.Command;
import com.company.example.movies.entity.User;
import com.company.example.movies.service.ServiceException;
import com.company.example.movies.service.ServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoToAdministratorPage implements Command {

    private static final Logger logger= LoggerFactory.getLogger(GoToAdministratorPage.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        List<User> users = null;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        try {
            users = serviceFactory.getUserService().users();
            request.setAttribute("users", users);
        } catch (ServiceException e) {
            logger.error("ошибка при попытке получить список пользователей", e);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/administratorPage.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            logger.error("ошибка при попытке перейти на administratorPage.jsp", e);
        }
    }
}
