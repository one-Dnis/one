package com.company.example.movies.service.impl;

import com.company.example.movies.dao.DAOException;
import com.company.example.movies.dao.DAOFactory;
import com.company.example.movies.entity.MovieReview;
import com.company.example.movies.service.MovieReviewService;
import com.company.example.movies.service.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class MovieReviewServiceImpl implements MovieReviewService {
    @Override
    public double movieRating(String title) throws ServiceException {

        List<MovieReview> movieReviewList = null;
        DAOFactory daoFactory = DAOFactory.getInstance();
        int cont = 0;
        double rank = 0;

        try {
            if (daoFactory.getMovieDAO().isMovieExists(title)) {
                movieReviewList = daoFactory.getMovieReviewDAO().movieReviews();
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        for (MovieReview movieReview: movieReviewList) {
            if(movieReview.getMovie().equalsIgnoreCase(title)) {
                cont = cont + 1;
                rank = rank + movieReview.getMark();
            }
        }
        return rank / cont;
    }

    @Override
    public boolean newReview(Double mark, String movieReview, String user, String movie) throws ServiceException {

        DAOFactory daoFactory = DAOFactory.getInstance();
        boolean isDone = false;
        try {
            if(daoFactory.getUserDAO().isUserExists(user) && !(daoFactory.getMovieReviewDAO().isReviewExists(user, movie))) {
              daoFactory.getMovieReviewDAO().newReview(mark, movieReview, user, movie);
              isDone = true;
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return isDone;
    }

    @Override
    public List<MovieReview> movieReviews(String movie) throws ServiceException {
        List<MovieReview> allMovieReviewList;
        List<MovieReview> movieReviewList = new ArrayList<>();
        DAOFactory daoFactory = DAOFactory.getInstance();
        try {
            allMovieReviewList = daoFactory.getMovieReviewDAO().movieReviews();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        for(MovieReview movieReview: allMovieReviewList) {
            if(movieReview.getMovie().equalsIgnoreCase(movie)) {
                movieReviewList.add(movieReview);
            }
        }
        return movieReviewList;
    }
}
