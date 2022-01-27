package com.company.example.movies.service;

import com.company.example.movies.service.impl.MoviesServiceImpl;
import com.company.example.movies.service.impl.UserServiceImpl;

public final class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();
    private final UserService userService = new UserServiceImpl();
    private final MovieService movieService = new MoviesServiceImpl();

    private ServiceFactory() {
    }

    public UserService getUserService() {
        return userService;
    }

    public MovieService getMovieService() {
        return movieService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
