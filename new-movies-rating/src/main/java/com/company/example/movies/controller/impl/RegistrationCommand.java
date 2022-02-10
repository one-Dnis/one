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

public class RegistrationCommand implements Command {

    private static final Logger logger= LoggerFactory.getLogger(NewMovieCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        String login;
        String password;
        String info;
        boolean flag = false;
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
            logger.error("ошибка при попытке регистрации нового пользователя:" + login, e);
        }

        if(!flag && !"".equalsIgnoreCase(login) && !"".equalsIgnoreCase(password)) {

            message = "вы зарегистрировались как " + login;
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/messagePage.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                logger.error("ошибка при попытке перейти на messagePage.jsp", e);
            }

            //response.sendRedirect("MyController?command=goToMainPage&message=регистрация успешна");//как параметр реквеста

        } else {
            //request.setAttribute("errorMessage", "error");
            message = "регистрация не удалась";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/messagePage.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                logger.error("ошибка при попытке перейти на messagePage.jsp", e);
            }
            //response.sendRedirect("MyController?command=goToErrorPage&message=регистрация не удалась");//лучше редиректом(F5)


        }

    }
}
