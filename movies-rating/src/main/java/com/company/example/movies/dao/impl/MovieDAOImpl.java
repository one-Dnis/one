package com.company.example.movies.dao.impl;

import com.company.example.movies.dao.DAOException;
import com.company.example.movies.dao.MovieDAO;
import com.company.example.movies.dao.connectionpool.ConnectionPoolAccess;
import com.company.example.movies.dao.connectionpool.ConnectionPoolException;
import com.company.example.movies.entity.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDAOImpl implements MovieDAO {
    @Override
    public boolean addMovie(Movie movie) throws DAOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Savepoint savepoint;

        try {
            ConnectionPoolAccess connectionPoolAccess = new ConnectionPoolAccess();
            connection = connectionPoolAccess.getConnection();
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("point");
        } catch (SQLException | ConnectionPoolException e ) {
            throw new DAOException(e);
        }

        try {
            preparedStatement = connection.prepareStatement("INSERT movies(title, year, short_description) VALUES(?, ?, ?)");

            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setInt(2, movie.getYear());
            preparedStatement.setString(3, movie.getShortDescription());

            preparedStatement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
        try {
            connection.rollback(savepoint);
        } catch (SQLException ex) {
            throw new DAOException(ex);
        }
        throw new DAOException(e);
    }
        try {
            if(resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        try {
            if(preparedStatement != null) {
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

        return true;

    }

    @Override
    public boolean deleteMovie(String title) throws DAOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Savepoint savepoint;

        try {
            ConnectionPoolAccess connectionPoolAccess = new ConnectionPoolAccess();
            connection = connectionPoolAccess.getConnection();
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("point");
        } catch (SQLException | ConnectionPoolException e ) {
            throw new DAOException(e);
        }

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM movies WHERE title = ?");


            preparedStatement.setString(1, title);

            preparedStatement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
        try {
            connection.rollback(savepoint);
        } catch (SQLException ex) {
            throw new DAOException(ex);
        }
        throw new DAOException(e);
    }
        try {
            if(resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }

        try {
            if(preparedStatement != null) {
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

        return true;

    }

    @Override
    public boolean editMovie(Movie movie) {
        return false;
    }

    @Override
    public List<Movie> movies() throws DAOException {

        List<Movie> movies = new ArrayList<>();

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
                "movies_rating.movies.id, " +
                "movies_rating.movies_type.title AS type, " +
                "movies_rating.movies.title, " +
                "movies_rating.movies.year, " +
                "movies_rating.movies.short_description " +
                "FROM movies_rating.movies JOIN movies_rating.movies_type " +
                "ON movies_rating.movies.movies_type_id = movies_rating.movies_type.id");

        while (resultSet.next()) {

            Movie movie = new Movie();

            movie.setId(resultSet.getInt(1));
            movie.setType(resultSet.getString(2));
            movie.setTitle(resultSet.getString(3));
            movie.setYear(resultSet.getInt(4));

            movie.setShortDescription(resultSet.getString(5));

            movies.add(movie);
        }

    } catch (SQLException e) {
        throw new DAOException(e);
    }

        try {
        if(resultSet != null) {
            resultSet.close();
        }
    } catch (SQLException e) {
        throw new DAOException(e);
    }

        try {
        if(statement != null) {
            statement.close();
        }
    } catch (SQLException e) {
        throw new DAOException(e);
    }

        try {
        connection.close();
    } catch (SQLException e) {
        throw new DAOException(e);
    }

        return movies;
    }
}
