package com.company.example.movies.controller.impl;

import com.company.example.movies.controller.Command;
import com.company.example.movies.entity.Movie;
import com.company.example.movies.service.ServiceException;
import com.company.example.movies.service.ServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GoToMainPage implements Command {

    private static final Logger logger= LoggerFactory.getLogger(GoToMainPage.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        List<Movie> movies = null;
       /* String role = "guest";
        String login = null;
        UserService userService = ServiceFactory.getInstance().getUserService();

        Cookie[] cookies = request.getCookies();
        String cookieName = "user";
        Cookie cookie = null;
        if(cookies != null) {
            for(Cookie c: cookies) {
                if(cookieName.equalsIgnoreCase(c.getName())) {
                    cookie = c;
                    break;
                }
            }
            try {
                if(cookie.getName() != null && userService.isUserExist(cookie.getName())) {
                    role = userService.authorization(cookie.getName(), cookie.getValue());
                    login = cookie.getName();
                }
            } catch (ServiceException e) {
                throw new ControllerException( e);
            }
        }*/

        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            movies = serviceFactory.getMovieService().movies();
        } catch (ServiceException e) {
            logger.error("ошибка при попытке получить список пользователей", e);
        }



        HttpSession session = request.getSession();
        session.setAttribute("movies", movies);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mainPage.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            logger.error("ошибка при попытке перейти на mainPage.jsp", e);
        }
    }
}
