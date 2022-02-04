package com.company.example.movies.service.impl;

import com.company.example.movies.dao.DAOException;
import com.company.example.movies.dao.DAOFactory;
import com.company.example.movies.entity.Movie;
import com.company.example.movies.service.MovieService;
import com.company.example.movies.service.ServiceException;

import java.util.List;

public class MovieServiceImpl implements MovieService {
    @Override
    public List<Movie> movies() throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            return daoFactory.getMovieDAO().movies();
        } catch (DAOException e){
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean newMovie(String title, String type, int year, String shortDescription) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        boolean isDone;
        int typeId = 1;
        if(!type.equalsIgnoreCase("фильм")) {
            typeId = 2;
        }


        try {
            if(!daoFactory.getMovieDAO().isMovieExists(title)) {
                daoFactory.getMovieDAO().newMovie(title, year, typeId, shortDescription);
            }
            isDone = true;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return isDone;
    }

    @Override
    public boolean editMovie(String title, String newTitle, String type, int year, String shortDescription) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        boolean isDone;
        int typeId = 1;
        if(!type.equalsIgnoreCase("фильм")) {
            typeId = 2;
        }


        try {
            if(!daoFactory.getMovieDAO().isMovieExists(title)) {
                daoFactory.getMovieDAO().editMovie(title, newTitle, year, typeId, shortDescription);
            }
            isDone = true;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return isDone;
    }

  /*  @Override
    public double movieRating() {
        return 0;
    }*/

    @Override
    public boolean deleteMovie(String title) throws ServiceException {
        boolean isDone;
        DAOFactory daoFactory = DAOFactory.getInstance();
        try {
            if (!daoFactory.getMovieDAO().isMovieExists(title)) {
                daoFactory.getMovieDAO().deleteMovie(title);
                isDone = true;
            } else {
                isDone = false;
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return isDone;
    }
}
