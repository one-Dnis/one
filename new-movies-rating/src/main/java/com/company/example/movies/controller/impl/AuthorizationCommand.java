package com.company.example.movies.controller.impl;

import com.company.example.movies.controller.Command;
import com.company.example.movies.controller.ControllerException;
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


public class AuthorizationCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ControllerException {
        String login;
        String password;
        String role = "guest";
        String message;

        login = request.getParameter("login");
        password = request.getParameter("password");

        ServiceFactory factory = ServiceFactory.getInstance();
        UserService userService = factory.getUserService();

        try {
            if(userService.isUserExist(login)) {
                role = userService.authorization(login, password);
            }
        } catch (ServiceException e) {
            throw new ControllerException( e);
        }

        HttpSession session = request.getSession(true);

        if(!"".equalsIgnoreCase(role) && role.equalsIgnoreCase("banned")) {
            message = "вы забанены и не можете войти";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/messagePage.jsp");
            dispatcher.forward(request, response);

        } else if (!"".equalsIgnoreCase(role) && (role.equalsIgnoreCase("user") | (role.equalsIgnoreCase("admin")))) {

            session.setAttribute("userName", login);
            session.setAttribute("role", role);

            Cookie cookie = new Cookie(login, login + "cookie");
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mainPage.jsp");
            dispatcher.forward(request, response);
        } else {
            message = "неверный логин или пароль";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/messagePage.jsp");
            dispatcher.forward(request, response);
        }
    }

}
