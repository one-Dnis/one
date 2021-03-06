package com.company.example.movies.dao.impl;

import com.company.example.movies.dao.DAOException;
import com.company.example.movies.dao.DAOFactory;
import com.company.example.movies.dao.MovieReviewDAO;
import com.company.example.movies.dao.connectionpool.ConnectionPoolAccess;
import com.company.example.movies.dao.connectionpool.ConnectionPoolException;
import com.company.example.movies.entity.MovieReview;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieReviewDAOImpl implements MovieReviewDAO {

    private static final Logger logger= LoggerFactory.getLogger(MovieReviewDAOImpl.class);

    @Override
    public List<MovieReview> movieReviews() throws DAOException {

        List<MovieReview> movieReviews = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ConnectionPoolAccess connectionPoolAccess;

        try {
            connectionPoolAccess = new ConnectionPoolAccess();
            connection = connectionPoolAccess.getConnection();

            try {
                statement = connection.createStatement();
            try {
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
                logger.error("???????????? ?????? ?????????????? ???????????????? ???????????? ?????????????? ???? ????", e);
                throw new DAOException(e);
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                } catch (SQLException e) {
                    logger.error("resultSet ???? ?????????????? ??????????????", e);
                    throw new DAOException(e);
                }
            }
            } catch (SQLException e) {
                logger.error("???????????? ?????? ?????????????? ???????????????? ???????????? ?????????????? ???? ????", e);
                throw new DAOException(e);
            } finally {
                try {
                    if (statement != null) {
                        statement.close();
                    }
                } catch (SQLException e) {
                    logger.error("statement ???? ?????????????? ??????????????", e);
                    throw new DAOException(e);
                }
            }
        } catch (ConnectionPoolException e) {
            logger.error("???????????? ?????? ?????????????? ???????????????? ???????????? ?????????????? ???? ????", e);
            throw new DAOException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.error("connection ???? ?????????????? ??????????????", e);
                throw new DAOException(e);
            }
        }

        return movieReviews;
    }

    @Override
    public boolean newReview(Double mark, String filmReview, String user, String movie) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean isDone;
        Savepoint savepoint = null;
        int userID = DAOFactory.getInstance().getUserDAO().userID(user);
        int movieID = DAOFactory.getInstance().getMovieDAO().movieID(movie);


        try {
            ConnectionPoolAccess connectionPoolAccess = new ConnectionPoolAccess();
            connection = connectionPoolAccess.getConnection();
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("point");

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

        } catch (ConnectionPoolException e ) {
            logger.error("???????????? ?????? ?????????????? ???????????????? ?????????? ?????????? ?? ????", e);
            throw new DAOException(e);
        } catch (SQLException e) {
            if (savepoint != null) {
                try {
                    connection.rollback(savepoint);
                } catch (SQLException ex) {
                    logger.error("???? ?????????????? ???????????????? ???? ?? ?????????????????? ??????????????????", e);
                    throw new DAOException(ex);
                }
            }
            logger.error("???????????? ?????? ?????????????? ???????????????? ?????????? ?????????? ?? ????", e);
            throw new DAOException(e);
        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                logger.error("resultSet ???? ?????????????? ??????????????", e);
                throw new DAOException(e);
            }

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                logger.error("preparedStatement ???? ?????????????? ??????????????", e);
                throw new DAOException(e);
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.error("connection ???? ?????????????? ??????????????", e);
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

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean isExists;
        String username = null;
        String movieTitle = null;

        try {
            ConnectionPoolAccess connectionPoolAccess = new ConnectionPoolAccess();
            connection = connectionPoolAccess.getConnection();


            preparedStatement = connection.prepareStatement("SELECT " +
                    "movies_rating.movies.title, movies_rating.users.login " +
                    "FROM movies_rating.review " +
                    "JOIN movies_rating.movies " +
                    "ON movies_rating.review.movies_id=movies_rating.movies.id " +
                    "JOIN movies_rating.users " +
                    "ON movies_rating.review.users_id=movies_rating.users.id " +
                    "WHERE movies_rating.users.login = ? AND movies_rating.movies.title = ?;");
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, movie);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                username = resultSet.getString(1);
                movieTitle = resultSet.getString(2);
            }


            isExists = username != null & movieTitle != null;

        } catch (ConnectionPoolException | SQLException e) {
            logger.error("???????????? ?????? ?????????????? ?????????????????? ???????????????????? ???? ?????????? ?? ????", e);
            throw new DAOException(e);

        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                logger.error("resultSet ???? ?????????????? ??????????????", e);
                throw new DAOException(e);
            }

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                logger.error("preparedStatement ???? ?????????????? ??????????????", e);
                throw new DAOException(e);
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.error("connection ???? ?????????????? ??????????????", e);
                throw new DAOException(e);
            }
        }

        return isExists;
    }
}
