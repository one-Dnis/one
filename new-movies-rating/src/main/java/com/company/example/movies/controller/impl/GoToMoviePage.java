package com.company.example.movies.controller.impl;

import com.company.example.movies.controller.Command;
import com.company.example.movies.entity.Movie;
import com.company.example.movies.entity.MovieReview;
import com.company.example.movies.service.ServiceException;
import com.company.example.movies.service.ServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoToMoviePage implements Command {

    private static final Logger logger= LoggerFactory.getLogger(GoToMoviePage.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        String movieTitle = request.getParameter("movieTitle");
        int movieYear = 0;
        String movieDescription = null;
        List<MovieReview> movieReviewList = null;
        List<Movie> movieList = null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        double movieRating = 0.0;

        try {
            movieReviewList = serviceFactory.getMovieReviewService().movieReviews(movieTitle);
            movieList = serviceFactory.getMovieService().movies();
            movieRating = serviceFactory.getMovieReviewService().movieRating(movieTitle);
        } catch (ServiceException e) {
            logger.error("ошибка при попытке получить списки фильмов и списки отзывов", e);
        }

        for (Movie movie: movieList) {
            if (movie.getTitle().equalsIgnoreCase(movieTitle)) {
               movieYear = movie.getYear();
               movieDescription = movie.getShortDescription();
            }
        }

        request.setAttribute("reviewList", movieReviewList);
        request.setAttribute("movieTitle", movieTitle);
        request.setAttribute("movieYear", movieYear);
        request.setAttribute("movieDescription", movieDescription);
        request.setAttribute("movieRating", movieRating);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/moviePage.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            logger.error("ошибка при попытке перейти на moviePage.jsp", e);
        }
    }
}
