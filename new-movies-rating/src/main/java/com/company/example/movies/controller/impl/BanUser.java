package com.company.example.movies.controller.impl;

import com.company.example.movies.controller.Command;
import com.company.example.movies.service.ServiceException;
import com.company.example.movies.service.ServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BanUser implements Command {

    private static final Logger logger= LoggerFactory.getLogger(BanUser.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("userPageName");
        boolean isDone = false;
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
            logger.error("ошибка при попытке забанить юзера:" + userName, e);
        }

        if(isDone) {
            message = "Юзер: " + userName + " забанен";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/messagePage.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                logger.error("ошибка при попытке перейти на messagePage.jsp", e);
            }
        } else {
            message = "не удалось забанить " + userName;
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/messagePage.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                logger.error("ошибка при попытке перейти на messagePage.jsp", e);
            }
        }

    }
}
