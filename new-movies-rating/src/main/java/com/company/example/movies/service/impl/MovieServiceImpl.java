package com.company.example.movies.service.impl;

import com.company.example.movies.dao.DAOException;
import com.company.example.movies.dao.DAOFactory;
import com.company.example.movies.entity.Movie;
import com.company.example.movies.service.MovieService;
import com.company.example.movies.service.ServiceException;
import com.company.example.movies.service.ServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MovieServiceImpl implements MovieService {

    private static final Logger logger= LoggerFactory.getLogger(MovieServiceImpl.class);

    @Override
    public List<Movie> movies() throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            List<Movie> movies = daoFactory.getMovieDAO().movies();
            for(Movie movie: movies) {
                movie.setRating(serviceFactory.getMovieReviewService().movieRating(movie.getTitle()));
            }
            movies.sort((o1, o2) -> {
                return Double.compare(o2.getRating(), o1.getRating());
            });


            return movies;
        } catch (DAOException e){
            logger.error("ошибка при попытке получить список фильмов", e);
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean newMovie(String title, String type, int year, String shortDescription) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        boolean isDone = false;
        int typeId = 1;

        if(!type.equalsIgnoreCase("фильм")) {
            typeId = 2;
        }

        try {
            if(!"".equalsIgnoreCase(title) && !daoFactory.getMovieDAO().isMovieExists(title)) {
                daoFactory.getMovieDAO().newMovie(title, year, typeId, shortDescription);
                isDone = true;
            }

        } catch (DAOException e) {
            logger.error("ошибка при попытке добавить новый фильм", e);
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
            logger.error("ошибка при попытке редактировать фильм", e);
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
            logger.error("ошибка при попытке удалить фильм", e);
            throw new ServiceException(e);
        }
        return isDone;
    }

}
