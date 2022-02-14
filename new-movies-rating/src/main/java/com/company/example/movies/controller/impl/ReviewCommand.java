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
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ReviewCommand implements Command {

    private static final Logger logger= LoggerFactory.getLogger(ReviewCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String mark;
        String movieReview;
        String user;
        String movie;
        boolean isDone = false;
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
            logger.error("ошибка при попытке добавить отзыв на фильм:" + movie + "пользователем:" + user, e);
        }

        if (isDone) {
            message = "отзыв добавлен";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/messagePage.jsp");
            //response.sendRedirect("MainController?command=goToMessagePage&message=" + "отзыв добавлен");
            try {
                request.setCharacterEncoding("UTF-8");
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                logger.error("ошибка при попытке перейти на messagePage.jsp", e);
            }
        } else {
            message = "не удалось добавить отзыв";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/messagePage.jsp");
            //response.sendRedirect("MainController?command=goToMessagePage&message=" + "не удалось добавить отзыв");
            try {
                request.setCharacterEncoding("UTF-8");
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                logger.error("ошибка при попытке перейти на messagePage.jsp", e);
            }
        }
    }
}
