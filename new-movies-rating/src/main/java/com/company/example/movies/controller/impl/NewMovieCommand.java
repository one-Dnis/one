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

public class NewMovieCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ControllerException {
        String title;
        String type;
        String year;
        String shortDescription;
        boolean isDone;
        String message;

        title = request.getParameter("NEW_TITLE");
        type = request.getParameter("NEW_TYPE");
        year = request.getParameter("NEW_YEAR");
        int formattedYear = Integer.parseInt(year);
        shortDescription = request.getParameter("NEW_SHORT_DESCRIPTION");

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        try {
            serviceFactory.getMovieService().newMovie(title, type, formattedYear, shortDescription);
            isDone = true;
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }

        if(isDone) {
            message = "успешно";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/messagePage.jsp");
            //response.sendRedirect("MyController?command=goToMessagePage&message=" + "отзыв добавлен");
            dispatcher.forward(request, response);
        } else {
            message = "не удалось добавить";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/messagePage.jsp");
            //response.sendRedirect("MyController?command=goToMessagePage&message=" + "не удалось добавить отзыв");
            dispatcher.forward(request, response);
        }
    }
}
