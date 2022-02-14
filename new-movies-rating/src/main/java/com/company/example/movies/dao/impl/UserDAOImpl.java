package com.company.example.movies.dao.impl;


import com.company.example.movies.dao.DAOException;
import com.company.example.movies.dao.UserDAO;
import com.company.example.movies.dao.connectionpool.ConnectionPoolAccess;
import com.company.example.movies.dao.connectionpool.ConnectionPoolException;
import com.company.example.movies.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private static final Logger logger= LoggerFactory.getLogger(UserDAOImpl.class);

    @Override
    public String authorization(String login, String password) throws DAOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String role = "WRONG";

        try {
            ConnectionPoolAccess connectionPoolAccess = new ConnectionPoolAccess();
            connection = connectionPoolAccess.getConnection();

            preparedStatement = connection.prepareStatement("SELECT " +
                    "movies_rating.users_roles.title, " +
                    "movies_rating.users.login, " +
                    "movies_rating.users.password " +
                    "FROM movies_rating.users " +
                    "JOIN movies_rating.users_roles ON movies_rating.users.users_roles_id=movies_rating.users_roles.id " +
                    "WHERE movies_rating.users.login=? AND movies_rating.users.password=?;");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                role = resultSet.getString(1);

            }
        } catch (ConnectionPoolException | SQLException e) {
            logger.error("ошибка при попытке получить данные для авторизации из БД", e);
            throw new DAOException(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                logger.error("resultSet не удалось закрыть", e);
                throw new DAOException(e);
            }

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                logger.error("preparedStatement не удалось закрыть", e);
                throw new DAOException(e);
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.error("connection не удалось закрыть", e);
                throw new DAOException(e);
            }
        }

        return role;
    }

    @Override
    public boolean newUser(String login, String password, String userInfo) throws DAOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        boolean isDone;
        Savepoint savepoint = null;


        try {
            ConnectionPoolAccess connectionPoolAccess = new ConnectionPoolAccess();
            connection = connectionPoolAccess.getConnection();
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("point");

            preparedStatement = connection.prepareStatement("INSERT movies_rating.users" +
                    "(movies_rating.users.users_roles_id, " +
                    "movies_rating.users.login, " +
                    "movies_rating.users.password, " +
                    "movies_rating.users.rank, " +
                    "movies_rating.users.user_info) VALUES(?, ?, ?, ?, ?);");


            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, login);
            preparedStatement.setString(3, password);
            preparedStatement.setDouble(4, 0);
            preparedStatement.setString(5, userInfo);

            preparedStatement.executeUpdate();
            connection.commit();

            isDone = true;

        } catch (ConnectionPoolException e) {
            logger.error("ошибка при попытке добавить новго пользователя в БД", e);
            throw new DAOException(e);
        } catch (SQLException e) {
            if (savepoint != null) {
                try {
                    connection.rollback(savepoint);
                } catch (SQLException ex) {
                    logger.error("не удалось откатить БД к исходному состоянию", e);
                    throw new DAOException(ex);
                }
            }
            logger.error("ошибка при попытке добавить новго пользователя в БД", e);
            throw new DAOException(e);
        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                logger.error("resultSet не удалось закрыть", e);
                throw new DAOException(e);
            }

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                logger.error("preparedStatement не удалось закрыть", e);
                throw new DAOException(e);
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.error("connection не удалось закрыть", e);
                throw new DAOException(e);
            }
        }

        return isDone;
    }

    @Override
    public boolean setUserRank(String userName, double rank) throws DAOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Savepoint savepoint = null;
        boolean isDone;


        try {
            ConnectionPoolAccess connectionPoolAccess = new ConnectionPoolAccess();
            connection = connectionPoolAccess.getConnection();
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("point");

            preparedStatement = connection.prepareStatement("UPDATE movies_rating.users " +
                    "SET movies_rating.users.rank = movies_rating.users.rank + ?" +
                    "WHERE movies_rating.users.login = ?;");

            preparedStatement.setDouble(1, rank);
            preparedStatement.setString(2, userName);

            preparedStatement.executeUpdate();
            connection.commit();

            isDone = true;
        } catch (ConnectionPoolException e ) {
            logger.error("ошибка при попытке изменить рейтинг пользователя в БД", e);
            throw new DAOException(e);
        } catch (SQLException e) {
            if (savepoint != null) {
                try {
                    connection.rollback(savepoint);
                } catch (SQLException ex) {
                    logger.error("не удалось откатить БД к исходному состоянию", e);
                    throw new DAOException(ex);
                }
            }
            logger.error("ошибка при попытке изменить рейтинг пользователя в БД", e);
            throw new DAOException(e);

        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                logger.error("resultSet не удалось закрыть", e);
                throw new DAOException(e);
            }

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                logger.error("preparedStatement не удалось закрыть", e);
                throw new DAOException(e);
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.error("connection не удалось закрыть", e);
                throw new DAOException(e);
            }
        }

        return isDone;

    }

    @Override
    public boolean editUser(String userName, String userInfo) throws DAOException {

        Connection connection= null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Savepoint savepoint = null;
        boolean isDone;

        try {
            ConnectionPoolAccess connectionPoolAccess = new ConnectionPoolAccess();
            connection = connectionPoolAccess.getConnection();
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("point");

            preparedStatement = connection.prepareStatement("UPDATE movies_rating.users " +
                    "SET movies_rating.users.user_info = ?" +
                    "WHERE movies_rating.users.login = ?;");

            preparedStatement.setString(1, userInfo);
            preparedStatement.setString(2, userName);

            preparedStatement.executeUpdate();
            connection.commit();

            isDone = true;

        } catch (ConnectionPoolException e ) {
            logger.error("ошибка при попытке изменить данные пользователя в БД", e);
            throw new DAOException(e);
        } catch (SQLException e) {
            if (savepoint != null) {
                try {
                    connection.rollback(savepoint);
                } catch (SQLException ex) {
                    logger.error("не удалось откатить БД к исходному состоянию", e);
                    throw new DAOException(ex);
                }
            }
            logger.error("ошибка при попытке изменить данные пользователя в БД", e);
            throw new DAOException(e);

        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                logger.error("resultSet не удалось закрыть", e);
                throw new DAOException(e);
            }

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                logger.error("preparedStatement не удалось закрыть", e);
                throw new DAOException(e);
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.error("connection не удалось закрыть", e);
                throw new DAOException(e);
            }
        }

        return isDone;

    }

    /*@Override
    public boolean deleteUser(String userName) {
        return false;
    }*/

    @Override
    public boolean isUserExists(String login) throws DAOException {

        List<String> users = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        boolean isExists;

        try {
            ConnectionPoolAccess connectionPoolAccess = new ConnectionPoolAccess();
            connection = connectionPoolAccess.getConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT movies_rating.users.login FROM movies_rating.users");

                while (resultSet.next()) {
                    users.add(resultSet.getString(1));
                }
                isExists = users.contains(login);


        } catch (ConnectionPoolException | SQLException e) {
            logger.error("ошибка при попытке проверить существование пользователя в БД", e);
            throw new DAOException(e);

        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                logger.error("resultSet не удалось закрыть", e);
                throw new DAOException(e);
            }

            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                logger.error("statement не удалось закрыть", e);
                throw new DAOException(e);
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.error("connection не удалось закрыть", e);
                throw new DAOException(e);
            }
        }

        return isExists;
    }

    @Override
    public List<User> users() throws DAOException{

        List<User> users = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            ConnectionPoolAccess connectionPoolAccess = new ConnectionPoolAccess();
            connection = connectionPoolAccess.getConnection();


                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT movies_rating.users.id, " +
                        "movies_rating.users_roles.title, movies_rating.users.login, " +
                        "movies_rating.users.password, movies_rating.users.rank, " +
                        "movies_rating.users.user_info FROM movies_rating.users " +
                        "JOIN movies_rating.users_roles ON movies_rating.users_roles.id = movies_rating.users.users_roles_id");

                while (resultSet.next()) {

                    User user = new User();

                    user.setId(resultSet.getInt(1));
                    user.setRole(resultSet.getString(2));
                    user.setLogin(resultSet.getString(3));
                    user.setPassword(resultSet.getString(4));
                    user.setRank(resultSet.getDouble(5));
                    user.setInfo(resultSet.getString(6));

                    users.add(user);
                }

        } catch (ConnectionPoolException | SQLException e) {
            logger.error("ошибка при попытке получить список пользователей в БД", e);
            throw new DAOException(e);
        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                logger.error("resultSet не удалось закрыть", e);
                throw new DAOException(e);
            }

            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                logger.error("statement не удалось закрыть", e);
                throw new DAOException(e);
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.error("connection не удалось закрыть", e);
                throw new DAOException(e);
            }
        }

        return users;
    }

    @Override
    public int userID(String login) throws DAOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int userID = 0;

        try {
            ConnectionPoolAccess connectionPoolAccess = new ConnectionPoolAccess();
            connection = connectionPoolAccess.getConnection();

            preparedStatement = connection.prepareStatement("SELECT " +
                    "movies_rating.users.id FROM movies_rating.users " +
                    "WHERE movies_rating.users.login = ?;");
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                userID = resultSet.getInt(1);

            }
        } catch (ConnectionPoolException | SQLException e) {
            logger.error("ошибка при попытке получить id пользователя из БД", e);
            throw new DAOException(e);
        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                logger.error("resultSet не удалось закрыть", e);
                throw new DAOException(e);
            }

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                logger.error("preparedStatement не удалось закрыть", e);
                throw new DAOException(e);
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.error("connection не удалось закрыть", e);
                throw new DAOException(e);
            }
        }

        return userID;
    }

    @Override
    public  boolean changeUserRole(String login, int role) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Savepoint savepoint = null;
        boolean isDone;

        try {
            ConnectionPoolAccess connectionPoolAccess = new ConnectionPoolAccess();
            connection = connectionPoolAccess.getConnection();
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("point");

            preparedStatement = connection.prepareStatement("UPDATE users SET users_roles_id = ? WHERE login = ?;");

            preparedStatement.setInt(1, role);
            preparedStatement.setString(2, login);

            preparedStatement.executeUpdate();
            connection.commit();

            isDone = true;

        } catch (ConnectionPoolException e ) {
            logger.error("ошибка при попытке изменить роль пользователя в БД", e);
            throw new DAOException(e);
        } catch (SQLException e) {
            if (savepoint != null) {
                try {
                    connection.rollback(savepoint);
                } catch (SQLException ex) {
                    logger.error("не удалось откатить БД к исходному состоянию", e);
                    throw new DAOException(ex);
                }
            }
            logger.error("ошибка при попытке изменить роль пользователя в БД", e);
            throw new DAOException(e);

        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                logger.error("resultSet не удалось закрыть", e);
                throw new DAOException(e);
            }

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                logger.error("preparedStatement не удалось закрыть", e);
                throw new DAOException(e);
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.error("connection не удалось закрыть", e);
                throw new DAOException(e);
            }
        }

        return isDone;
    }

    @Override
    public int userRoleID(String login) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int roleId = 2;

        try {
            ConnectionPoolAccess connectionPoolAccess = new ConnectionPoolAccess();
            connection = connectionPoolAccess.getConnection();

            preparedStatement = connection.prepareStatement("SELECT " +
                    "movies_rating.users.users_roles_id FROM movies_rating.users " +
                    "WHERE movies_rating.users.login = ?;");
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                roleId = resultSet.getInt(1);
            }
        } catch (ConnectionPoolException | SQLException e) {
            logger.error("ошибка при попытке получить id пользователя из БД", e);
            throw new DAOException(e);
        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                logger.error("resultSet не удалось закрыть", e);
                throw new DAOException(e);
            }

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                logger.error("preparedStatement не удалось закрыть", e);
                throw new DAOException(e);
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.error("connection не удалось закрыть", e);
                throw new DAOException(e);
            }
        }

        return roleId;
    }

    @Override
    public double userMovieMark(String user, String movie) throws DAOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        double userMark = 0;

        try {
            ConnectionPoolAccess connectionPoolAccess = new ConnectionPoolAccess();
            connection = connectionPoolAccess.getConnection();

            preparedStatement = connection.prepareStatement("SELECT " +
                    "movies_rating.review.mark " +
                    "FROM movies_rating.review " +
                    "JOIN movies_rating.movies ON movies_rating.review.movies_id=movies_rating.movies.id " +
                    "JOIN movies_rating.users ON movies_rating.review.users_id=movies_rating.users.id " +
                    "WHERE movies_rating.movies.title = ? AND movies_rating.users.login = ?;");

            preparedStatement.setString(1, movie);
            preparedStatement.setString(2, user);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                userMark = resultSet.getDouble(1);
            }

        } catch (ConnectionPoolException | SQLException e) {
            logger.error("ошибка при попытке проверить существует ли отзыв в БД", e);
            throw new DAOException(e);

        } finally {

            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                logger.error("resultSet не удалось закрыть", e);
                throw new DAOException(e);
            }

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                logger.error("preparedStatement не удалось закрыть", e);
                throw new DAOException(e);
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                logger.error("connection не удалось закрыть", e);
                throw new DAOException(e);
            }
        }

        return userMark;
    }

}
