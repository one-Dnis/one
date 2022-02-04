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
    public boolean newMovie(String title, int year, int typeID, String shortDescription) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Savepoint savepoint;
        boolean isDone;

        try {
            ConnectionPoolAccess connectionPoolAccess = new ConnectionPoolAccess();
            connection = connectionPoolAccess.getConnection();
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("point");
        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        }

        try {
            preparedStatement = connection.prepareStatement("INSERT movies(title, movies_type_id, year, short_description) VALUES(?, ?, ?, ?)");

            preparedStatement.setString(1, title);
            preparedStatement.setInt(2, typeID);
            preparedStatement.setInt(3, year);
            preparedStatement.setString(4, shortDescription);

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
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }

        return isDone;

    }

    @Override
    public boolean deleteMovie(String title) throws DAOException {

        Connection connection;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Savepoint savepoint;
        boolean isDone;

        try {
            ConnectionPoolAccess connectionPoolAccess = new ConnectionPoolAccess();
            connection = connectionPoolAccess.getConnection();
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("point");
        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        }

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM movies WHERE title = ?");


            preparedStatement.setString(1, title);

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
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }

        return isDone;

    }

    @Override
    public boolean editMovie(String title, String newTitle, int typeID, int year, String shortDescription) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Savepoint savepoint;
        boolean isDone;

        try {
            ConnectionPoolAccess connectionPoolAccess = new ConnectionPoolAccess();
            connection = connectionPoolAccess.getConnection();
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("point");
        } catch (SQLException | ConnectionPoolException e) {
            throw new DAOException(e);
        }

        try {
            preparedStatement = connection.prepareStatement("UPDATE movies_rating.movies " +
                    "SET movies_rating.movies.title = ?, movies_rating.movies.movies_type_id = ?," +
                    " movies_rating.movies.year = ?, movies_rating.movies.short_description = ?" +
                    "WHERE movies_rating.movies.title = ?;");

            preparedStatement.setString(1, newTitle);
            preparedStatement.setInt(2, typeID);
            preparedStatement.setInt(3, year);
            preparedStatement.setString(4, shortDescription);
            preparedStatement.setString(5, title);

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
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new DAOException(e);
            }
        }

        return isDone;
    }

    @Override
    public List<Movie> movies() throws DAOException {

        List<Movie> movies = new ArrayList<>();

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

        return movies;
    }

    @Override
    public boolean isMovieExists(String title) throws DAOException {

        List<String> movies = new ArrayList<>();

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
            resultSet = statement.executeQuery("SELECT movies_rating.movies.title FROM movies_rating.movies");

            while (resultSet.next()) {
                movies.add(resultSet.getString(1));
            }

            isExists = movies.contains(title);

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

    @Override
    public int movieID(String title) throws DAOException {
        Connection connection;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int movieID = 0;

        try {
            ConnectionPoolAccess connectionPoolAccess = new ConnectionPoolAccess();
            connection = connectionPoolAccess.getConnection();
        } catch (ConnectionPoolException e) {
            throw new DAOException(e);
        }

        try {
            preparedStatement = connection.prepareStatement("SELECT movies_rating.movies.id FROM movies_rating.movies WHERE movies_rating.movies.title = ?;");
            preparedStatement.setString(1, title);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                movieID = resultSet.getInt(1);

            }
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
                if (preparedStatement != null) {
                    preparedStatement.close();
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

        return movieID;
    }

}
