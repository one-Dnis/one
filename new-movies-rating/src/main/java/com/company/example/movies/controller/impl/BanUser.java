package com.company.example.movies.controller.impl;

import com.company.example.movies.controller.Command;
import com.company.example.movies.controller.ControllerException;
import com.company.example.movies.service.ServiceException;
import com.company.example.movies.service.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BanUser implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ControllerException {
        String userName = request.getParameter("userPageName");
        boolean isDone;
        String message;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();

        try {
            if(!serviceFactory.getUserService().isUserInBan(userName)) {
                serviceFactory.getUserService().banUser(userName);
                isDone = true;
            } else {
                isDone = false;
            }
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }

        if(isDone) {
            message = "Юзер: " + userName + " забанен";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/messagePage.jsp");
            dispatcher.forward(request, response);
        } else {
            message = "не удалось забанить " + userName;
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/messagePage.jsp");
            dispatcher.forward(request, response);
        }

    }
}
