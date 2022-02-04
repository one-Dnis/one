package com.company.example.movies.controller.impl;

import com.company.example.movies.controller.Command;
import com.company.example.movies.controller.ControllerException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToUserPage implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ControllerException {
        String userPageName = request.getParameter("userPageName");

        request.setAttribute("userPageName", userPageName);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userPage.jsp");
        dispatcher.forward(request, response);
    }
}