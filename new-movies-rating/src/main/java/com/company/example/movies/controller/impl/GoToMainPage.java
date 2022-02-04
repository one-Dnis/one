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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GoToMainPage implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ControllerException {
        List<Movie> movies;

        try {
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            movies = serviceFactory.getMovieService().movies();
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }

        HttpSession session = request.getSession();
        session.setAttribute("movies", movies);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mainPage.jsp");
        dispatcher.forward(request, response);
    }
}
