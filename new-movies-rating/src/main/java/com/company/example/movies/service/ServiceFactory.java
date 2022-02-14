package com.company.example.movies.service;

import com.company.example.movies.service.impl.MovieReviewServiceImpl;
import com.company.example.movies.service.impl.MovieServiceImpl;
import com.company.example.movies.service.impl.UserServiceImpl;

public final class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();
    private final UserService userService = new UserServiceImpl();
    private final MovieService movieService = new MovieServiceImpl();
    private final MovieReviewService movieReviewService = new MovieReviewServiceImpl();

    private ServiceFactory() {
    }

    public UserService getUserService() {
        return userService;
    }

    public MovieService getMovieService() {
        return movieService;
    }

    public MovieReviewService getMovieReviewService() {
        return movieReviewService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
