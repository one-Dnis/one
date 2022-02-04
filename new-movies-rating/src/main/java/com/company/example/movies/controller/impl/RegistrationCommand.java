package com.company.example.movies.controller.impl;

import com.company.example.movies.controller.Command;
import com.company.example.movies.controller.ControllerException;
import com.company.example.movies.entity.Movie;
import com.company.example.movies.service.ServiceException;
import com.company.example.movies.service.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RegistrationCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ControllerException {

        String login;
        String password;
        String info;
        boolean flag;
        String message;

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

        if(!flag && !"".equalsIgnoreCase(login) && !"".equalsIgnoreCase(password)) {

            message = "вы зарегистрировались как " + login;
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/messagePage.jsp");
            dispatcher.forward(request, response);

            //response.sendRedirect("MyController?command=goToMainPage&message=регистрация успешна");//как параметр реквеста

        } else {
            //request.setAttribute("errorMessage", "error");
            message = "регистрация не удалась";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/messagePage.jsp");
            dispatcher.forward(request, response);
            //response.sendRedirect("MyController?command=goToErrorPage&message=регистрация не удалась");//лучше редиректом(F5)


        }

    }
}
