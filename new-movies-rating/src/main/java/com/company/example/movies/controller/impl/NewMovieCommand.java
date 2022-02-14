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

public class NewMovieCommand implements Command {

    private static final Logger logger= LoggerFactory.getLogger(NewMovieCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String title;
        String type;
        String year;
        String shortDescription;
        boolean isDone = false;
        String message;

        title = request.getParameter("NEW_TITLE");
        type = request.getParameter("NEW_TYPE");
        year = request.getParameter("NEW_YEAR");
        int formattedYear = Integer.parseInt(year);
        shortDescription = request.getParameter("NEW_SHORT_DESCRIPTION");

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        try {
            isDone = serviceFactory.getMovieService().newMovie(title, type, formattedYear, shortDescription);
        } catch (ServiceException e) {
            logger.error("ошибка при попытке добавить новый фильм", e);
        }

        if(isDone) {
            message = "успешно";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/messagePage.jsp");
            //response.sendRedirect("MainController?command=goToMessagePage&message=" + "отзыв добавлен");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                logger.error("ошибка при попытке перейти на messagePage.jsp", e);
            }
        } else {
            message = "не удалось добавить";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/messagePage.jsp");
            //response.sendRedirect("MainController?command=goToMessagePage&message=" + "не удалось добавить отзыв");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                logger.error("ошибка при попытке перейти на messagePage.jsp", e);
            }
        }
    }
}
