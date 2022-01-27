package com.company.example.movies.dao;

import com.company.example.movies.dao.impl.MovieDAOImpl;
import com.company.example.movies.dao.impl.UserDAOImpl;

public final class DAOFactory {

    private static final DAOFactory instance = new DAOFactory();
    private final UserDAO userDAO = new UserDAOImpl();
    private final MovieDAO movieDAO = new MovieDAOImpl();

    private DAOFactory() {
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public MovieDAO getMovieDAO() {
        return movieDAO;
    }

    public static DAOFactory getInstance() {
        return instance;
    }


}
