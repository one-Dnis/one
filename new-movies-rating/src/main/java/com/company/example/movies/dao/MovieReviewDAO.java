package com.company.example.movies.dao;

import com.company.example.movies.dao.connectionpool.ConnectionPoolException;
import com.company.example.movies.entity.MovieReview;

import java.sql.SQLException;
import java.util.List;

public interface MovieReviewDAO {

    List<MovieReview> movieReviews() throws DAOException;
    boolean newReview(Double mark, String filmReview, String user, String movie) throws DAOException;
   // void deleteReview(MovieReview review);
    boolean isReviewExists(String user, String movie) throws DAOException;

}
