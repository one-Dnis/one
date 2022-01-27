package com.company.example.movies.dao;

import com.company.example.movies.entity.User;

import java.util.List;

public interface UserDAO {

    String authorization(String login, String password) throws DAOException;
    boolean newUser(String login, String password, String userInfo) throws DAOException;
    void setUserRank() throws DAOException;
    void editUser() throws DAOException;
    void deleteUser(User user) throws DAOException;
    boolean isUserExists(String login) throws DAOException;
    List<User> users() throws DAOException;


}
