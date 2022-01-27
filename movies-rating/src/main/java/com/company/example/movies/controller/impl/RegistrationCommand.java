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
import java.io.PrintWriter;

public class RegistrationCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ControllerException {
        String login;
        String password;
        String info;
        boolean flag;

        login = request.getParameter("login");
        password = request.getParameter("password");
        info = request.getParameter("info");

        ServiceFactory serviceFactory = ServiceFactory.getInstance();



        try {
            flag = serviceFactory.getUserService().isUserExist(login);
            if (!flag)
            serviceFactory.getUserService().registration(login, password, info);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }



        if(!flag) {

            //request.setAttribute("registrationInfo", "done");
            response.sendRedirect("MyController?command=goToMainPage&registrationInfo=" + "done");//как параметр реквеста
            //RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mainPage.jsp");
            //dispatcher.forward(request, response);
        } else {
            //request.setAttribute("errorMessage", "error");
            response.sendRedirect("MyController?command=goToErrorPage&registrationInfo=" + "error");//лучше редиректом(F5)
            //RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registrationPage.jsp");
            //dispatcher.forward(request, response);
        }

    }
}
