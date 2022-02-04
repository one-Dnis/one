package com.company.example.movies.controller.impl;

import com.company.example.movies.controller.Command;
import com.company.example.movies.controller.ControllerException;
import com.company.example.movies.service.ServiceException;
import com.company.example.movies.service.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ReviewCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ControllerException {
        String mark;
        String movieReview;
        String user;
        String movie;
        boolean isDone;
        String message;
        double formattedMark;
        HttpSession session = request.getSession();

        mark = request.getParameter("mark");
        formattedMark = Double.parseDouble(mark);//from string to double
        movieReview = request.getParameter("movieReview");
        user = (String) session.getAttribute("userName");
        movie = request.getParameter("movieTitle");
        ServiceFactory serviceFactory = ServiceFactory.getInstance();


        try {
            isDone = serviceFactory.getMovieReviewService().newReview(formattedMark, movieReview, user, movie);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }

        if(isDone) {
            message = "отзыв добавлен";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/messagePage.jsp");
            //response.sendRedirect("MyController?command=goToMessagePage&message=" + "отзыв добавлен");
            dispatcher.forward(request, response);
        } else {
            message = "не удалось добавить отзыв";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/messagePage.jsp");
            //response.sendRedirect("MyController?command=goToMessagePage&message=" + "не удалось добавить отзыв");
            dispatcher.forward(request, response);
        }
    }
}
