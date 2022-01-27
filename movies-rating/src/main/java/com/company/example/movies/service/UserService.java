package com.company.example.movies.service;

import com.company.example.movies.dao.DAOException;

public interface UserService {

    String authorization(String login, String password) throws ServiceException;
    boolean registration(String login, String password, String info) throws ServiceException;
    boolean isUserExist(String login) throws ServiceException;
    boolean deleteUser(String login);
}
