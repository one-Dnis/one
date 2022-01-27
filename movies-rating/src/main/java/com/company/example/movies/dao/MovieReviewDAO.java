package com.company.example.movies.dao;

import com.company.example.movies.dao.connectionpool.ConnectionPoolException;
import com.company.example.movies.entity.MovieReview;

import java.sql.SQLException;
import java.util.List;

public interface MovieReviewDAO {

    List<MovieReview> movieReviews() throws DAOException;
    void addReview(MovieReview review);
    void deleteReview(MovieReview review);

}
