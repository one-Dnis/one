package com.company.example.movies.controller.impl;

import com.company.example.movies.controller.Command;
import com.company.example.movies.dao.DAOException;
import com.company.example.movies.service.ServiceException;
import com.company.example.movies.service.ServiceFactory;
import com.company.example.movies.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthorizationCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ServiceException {
        String login;
        String password;

        login = request.getParameter("login");
        password = request.getParameter("password");

        ServiceFactory factory = ServiceFactory.getInstance();
        UserService userService = factory.getUserService();
        String role = userService.authorization(login, password);

        HttpSession session = request.getSession(true);

        if(!"".equals(role)) {
            session.setAttribute("role", role);
            request.setAttribute("login", login);
            request.setAttribute("password", password);

            Cookie cookie = new Cookie("adminCookie", "adminCookie");
            response.addCookie(cookie);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mainPage.jsp");
            dispatcher.forward(request, response);
        } else {
            //написать что юзер не угадал свой пароль
        }

    }
}
