package com.company.example.movies.service.impl;

import com.company.example.movies.dao.DAOException;
import com.company.example.movies.dao.DAOFactory;
import com.company.example.movies.service.ServiceException;
import com.company.example.movies.service.UserService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserServiceImpl implements UserService {
    @Override
    public String authorization(String login, String password) throws ServiceException {
        //тут должна быть валидация
        String userRole;
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            userRole = daoFactory.getUserDAO().authorization(login, password);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return userRole;
    }

    @Override
    public boolean registration(String login, String password, String info) throws ServiceException {


        String loginAndPasswordFormat = "[a-zA-Z0-9]+";

        Pattern pattern = Pattern.compile(loginAndPasswordFormat);
        Matcher nameMatcher = pattern.matcher(login);
        Matcher passwordMatcher = pattern.matcher(password);

        boolean isUserExist;
        DAOFactory daoFactory = DAOFactory.getInstance();


        try {
            isUserExist = daoFactory.getUserDAO().isUserExists(login);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        //пока проверка всё сразу, разделить на есть такой пользователь и формат логин/пароль
        if (!isUserExist && nameMatcher.matches() && passwordMatcher.matches()) {
            try {
                daoFactory.getUserDAO().newUser(login, password, info);

            } catch (DAOException e) {
                throw new ServiceException(e);
            }
        }

        return true;
    }

    @Override
    public boolean isUserExist(String login) throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();

        try {
            return daoFactory.getUserDAO().isUserExists(login);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteUser(String login) {
        return false;
    }
}
