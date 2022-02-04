package com.company.example.movies.controller.impl;

import com.company.example.movies.controller.Command;
import com.company.example.movies.controller.ControllerException;
import com.company.example.movies.entity.Movie;
import com.company.example.movies.entity.MovieReview;
import com.company.example.movies.service.ServiceException;
import com.company.example.movies.service.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GoToMoviePage implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ControllerException {

        String movieTitle = request.getParameter("movieTitle");
        int movieYear = 0;
        String movieDescription = null;
        List<MovieReview> movieReviewList;
        List<Movie> movieList;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        double movieRating = 0.0;

        try {
            movieReviewList = serviceFactory.getMovieReviewService().movieReviews(movieTitle);
            movieList = serviceFactory.getMovieService().movies();
            movieRating = serviceFactory.getMovieReviewService().movieRating(movieTitle);
        } catch (ServiceException e) {
            throw new ControllerException(e);
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
        dispatcher.forward(request, response);
    }
}
