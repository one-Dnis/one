package com.company.example.movies.dao.impl;

import com.company.example.movies.dao.DAOException;
import com.company.example.movies.dao.MovieReviewDAO;
import com.company.example.movies.dao.connectionpool.ConnectionPoolAccess;
import com.company.example.movies.dao.connectionpool.ConnectionPoolException;
import com.company.example.movies.entity.MovieReview;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MovieReviewDAOImpl implements MovieReviewDAO {
    @Override
    public List<MovieReview> movieReviews() throws DAOException {

        List<MovieReview> movieReviews = new ArrayList<>();

        Connection connection;
        Statement statement;
        ResultSet resultSet;
        try {
            ConnectionPoolAccess connectionPoolAccess = new ConnectionPoolAccess();
            connection = connectionPoolAccess.getConnection();
        } catch (ConnectionPoolException e) {
            throw new DAOException(e);
        }

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT " +
                    "movies_rating.review.id, " +
                    "movies_rating.review.mark, " +
                    "movies_rating.review.film_review, " +
                    "movies_rating.users.login, " +
                    "movies_rating.movies.title " +
                    "FROM movies_rating.review " +
                    "JOIN movies_rating.movies " +
                    "ON movies_rating.review.id=movies_rating.movies.id " +
                    "JOIN movies_rating.users " +
                    "ON movies_rating.review.users_id=movies_rating.users.id;");

            while (resultSet.next()) {

                MovieReview movieReview = new MovieReview();

                movieReview.setId(resultSet.getInt(1));
                movieReview.setMark(resultSet.getInt(2));
                movieReview.setReview(resultSet.getString(3));
                movieReview.setUser(resultSet.getString(4));
                movieReview.setMovie(resultSet.getString(5));


                movieReviews.add(movieReview);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        try {
            resultSet.close();
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        try {
            statement.close();
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        try {
            connection.close();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return movieReviews;
    }

    @Override
    public void addReview(MovieReview review) {

    }

    @Override
    public void deleteReview(MovieReview review) {

    }
}
