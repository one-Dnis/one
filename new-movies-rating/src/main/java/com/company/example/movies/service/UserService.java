package com.company.example.movies.service;

import com.company.example.movies.entity.User;

import java.util.List;

public interface UserService {

    String authorization(String login, String password) throws ServiceException;
    boolean registration(String login, String password, String info) throws ServiceException;
    boolean isUserExist(String login) throws ServiceException;
    boolean setUserRank(String login, Double rank) throws ServiceException;
    List<User> users() throws ServiceException;
    void autoRank() throws ServiceException;
    boolean isUserInBan(String login) throws ServiceException;
    boolean banUser(String login) throws ServiceException;
}
