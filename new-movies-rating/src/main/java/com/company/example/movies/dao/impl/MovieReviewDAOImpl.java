package com.company.example.movies.dao.impl;

import com.company.example.movies.dao.DAOException;
import com.company.example.movies.dao.DAOFactory;
import com.company.example.movies.dao.MovieReviewDAO;
import com.company.example.movies.dao.connectionpool.ConnectionPoolAccess;
import com.company.example.movies.dao.connectionpool.ConnectionPoolException;
import com.company.example.movies.entity.MovieReview;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieReviewDAOImpl implements MovieReviewDAO {
    @Override
    public List<MovieReview> movieReviews() throws DAOException {

        List<MovieReview> movieReviews = new ArrayList<>();

        Connection connection;
        Statement statement = null;
        ResultSet resultSet = null;

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
                    "ON movies_rating.review.movies_id=movies_rating.movies.id " +
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

        } finally {

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
        }
        return movieReviews;
    }

    @Override
    public boolean newReview(Double mark, String filmReview, String user, String movie) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean isDone;
        Savepoint savepoint;
        int userID = DAOFactory.getInstance().getUserDAO().userID(user);
        int movieID = DAOFactory.getInstance().getMovieDAO().movieID(movie);


        try {
            ConnectionPoolAccess connectionPoolAccess = new ConnectionPoolAccess();
            connection = connectionPoolAccess.getConnection();
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("point");
        } catch (SQLException | ConnectionPoolException e ) {
            throw new DAOException(e);
        }

        try {
            preparedStatement = connection.prepareStatement("INSERT movies_rating.review" +
                    "(movies_rating.review.mark, " +
                    "movies_rating.review.film_review, " +
                    "movies_rating.review.users_id, " +
                    "movies_rating.review.movies_id) VALUES(?, ?, ?, ?);");

            preparedStatement.setDouble(1, mark);
            preparedStatement.setString(2, filmReview);
            preparedStatement.setInt(3, userID);
            preparedStatement.setInt(4, movieID);

            preparedStatement.executeUpdate();
            connection.commit();

            isDone = true;

        } catch (SQLException e) {
            try {
                connection.rollback(savepoint);
            } catch (SQLException ex) {
                throw new DAOException(ex);
            }
            throw new DAOException(e);
        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                throw new DAOException(e);
            }

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                throw new DAOException(e);
            }

            try {
                connection.close();
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }

        return isDone;
    }

   /* @Override
    public void deleteReview(MovieReview review) {

    }*/

    @Override
    public boolean isReviewExists(String user, String movie) throws DAOException {

        List<String> movies = new ArrayList<>();
        List<String> users = new ArrayList<>();

        Connection connection;
        Statement statement = null;
        ResultSet resultSet = null;
        boolean isExists;

        try {
            ConnectionPoolAccess connectionPoolAccess = new ConnectionPoolAccess();
            connection = connectionPoolAccess.getConnection();
        } catch (ConnectionPoolException e) {
            throw new DAOException(e);
        }

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT " +
                    "movies_rating.movies.title, movies_rating.users.login " +
                    "FROM movies_rating.review JOIN movies_rating.movies " +
                    "ON movies_rating.review.movies_id=movies_rating.movies.id " +
                    "JOIN movies_rating.users ON movies_rating.review.users_id=movies_rating.users.id;");

            while (resultSet.next()) {
                movies.add(resultSet.getString(1));
                users.add(resultSet.getString(2));
            }

            isExists = users.contains(user) & movies.contains(movie);

        } catch (SQLException e) {
            throw new DAOException(e);

        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                throw new DAOException(e);
            }

            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                throw new DAOException(e);
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }

        return isExists;
    }
}
