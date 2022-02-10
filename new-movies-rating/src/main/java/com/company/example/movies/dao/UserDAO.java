package com.company.example.movies.dao;

import com.company.example.movies.entity.User;

import java.util.List;

public interface UserDAO {

    String authorization(String login, String password) throws DAOException;
    boolean newUser(String login, String password, String userInfo) throws DAOException;
    boolean setUserRank(String userName, double rank) throws DAOException;
    boolean editUser(String userName, String userInfo) throws DAOException;
    /*boolean deleteUser(String userName) throws DAOException;*/
    boolean isUserExists(String login) throws DAOException;
    List<User> users() throws DAOException;
    int userID(String login) throws DAOException;
    boolean changeUserRole(String login, int role) throws DAOException;
    int userRoleID(String login) throws DAOException;


}
