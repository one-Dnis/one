package com.company.example.movies.controller.impl;

import com.company.example.movies.controller.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToUserPage implements Command {

    private static final Logger logger= LoggerFactory.getLogger(GoToUserPage.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String userPageName = request.getParameter("userPageName");
        String userPageRole = request.getParameter("userPageRole");

        request.setAttribute("userPageName", userPageName);
        request.setAttribute("userPageRole", userPageRole);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userPage.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            logger.error("ошибка при попытке перейти на userPage.jsp", e);
        }
    }
}
