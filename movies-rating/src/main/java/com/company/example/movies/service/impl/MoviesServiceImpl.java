package com.company.example.movies.service.impl;

import com.company.example.movies.dao.DAOException;
import com.company.example.movies.dao.DAOFactory;
import com.company.example.movies.entity.Movie;
import com.company.example.movies.service.MovieService;
import com.company.example.movies.service.ServiceException;

import java.util.List;

public class MoviesServiceImpl implements MovieService {
    @Override
    public List<Movie> movies() throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            return daoFactory.getMovieDAO().movies();
        } catch (DAOException e){
            throw new ServiceException(e);
        }
    }
}
