package com.company.example.movies.controller.impl;

import com.company.example.movies.controller.Command;
import com.company.example.movies.service.ServiceException;
import com.company.example.movies.service.ServiceFactory;
import com.company.example.movies.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class AuthorizationCommand implements Command {
    private static final Logger logger= LoggerFactory.getLogger(AuthorizationCommand.class);
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("authorization is started");

        String login;
        String password;
        String role = "WRONG";
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
            logger.error("не удалось проверить пользователя:" + login , e);
        }

        HttpSession session = request.getSession(true);

        if(!"".equalsIgnoreCase(role) && role.equalsIgnoreCase("banned")) {
            logger.debug("попытка входа находящегося в бане пользователя:" + login);
            message = "вы забанены и не можете войти";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/messagePage.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                logger.error("ошибка при попытке перейти на messagePage.jsp", e);
            }

        } else if (!"".equalsIgnoreCase(role) && (role.equalsIgnoreCase("user") | (role.equalsIgnoreCase("admin")))) {
            logger.debug("попытка входа пользователя:" + login);
            session.setAttribute("userName", login);
            session.setAttribute("role", role);

            Cookie cookie = new Cookie(login, password);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mainPage.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                logger.error("ошибка при попытке перейти на mainPage.jsp", e);
            }
        } else if(role.equalsIgnoreCase("WRONG")) {
            logger.debug("неудачная попытка входа пользователя:" + login);
            message = "неверный логин или пароль";
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
