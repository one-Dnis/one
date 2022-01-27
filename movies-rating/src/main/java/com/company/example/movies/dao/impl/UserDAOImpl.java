package com.company.example.movies.dao.impl;


import com.company.example.movies.dao.DAOException;
import com.company.example.movies.dao.UserDAO;
import com.company.example.movies.dao.connectionpool.ConnectionPoolAccess;
import com.company.example.movies.dao.connectionpool.ConnectionPoolException;
import com.company.example.movies.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAOImpl implements UserDAO {
    @Override
    public String authorization(String login, String password) throws DAOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String role = null;

        try {
            ConnectionPoolAccess connectionPoolAccess = new ConnectionPoolAccess();
            connection = connectionPoolAccess.getConnection();
        } catch (ConnectionPoolException e) {
            throw new DAOException(e);
        }

        try {
            preparedStatement = connection.prepareStatement("SELECT " +
                    "movies_rating.users_roles.title, " +
                    "movies_rating.users.login, " +
                    "movies_rating.users.password " +
                    "FROM movies_rating.users JOIN movies_rating.users_roles ON movies_rating.users.users_roles_id=movies_rating.users_roles.id " +
                    "WHERE movies_rating.users.login=? AND movies_rating.users.password=?;");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                role = resultSet.getString(1);

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

        return role;
    }

    @Override
    public boolean newUser(String login, String password, String userInfo) throws DAOException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String role = null;
        boolean isDone = false;
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

        return isDone;
    }

    @Override
    public void setUserRank() {

    }

    @Override
    public void editUser() {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public boolean isUserExists(String login) throws DAOException {

        List<String> users = new ArrayList<>();

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
            resultSet = statement.executeQuery("SELECT movies_rating.users.login FROM movies_rating.users");

            while (resultSet.next()) {
                users.add(resultSet.getString(1));
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

        return !users.contains(login);
    }

    @Override
    public List<User> users() throws DAOException{

        List<User> users = new ArrayList<>();

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

        return users;
    }

}
