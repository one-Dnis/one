package com.company.example.movies.service.impl;

import com.company.example.movies.dao.DAOException;
import com.company.example.movies.dao.DAOFactory;
import com.company.example.movies.entity.Movie;
import com.company.example.movies.entity.MovieReview;
import com.company.example.movies.entity.User;
import com.company.example.movies.service.ServiceException;
import com.company.example.movies.service.ServiceFactory;
import com.company.example.movies.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserServiceImpl implements UserService {
    @Override
    public String authorization(String login, String password) throws ServiceException {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        boolean isUserExist = serviceFactory.getUserService().isUserExist(login);
        String userRole = null;

        if (isUserExist) {
            try {
                DAOFactory daoFactory = DAOFactory.getInstance();
                userRole = daoFactory.getUserDAO().authorization(login, password);
            } catch (DAOException e) {
                throw new ServiceException(e);
            }
        }

        return userRole;//null if пользователь не зарегистрирован
    }

    @Override
    public boolean registration(String login, String password, String info) throws ServiceException {


        String loginAndPasswordFormat = "[a-zA-Z0-9]+";

        Pattern pattern = Pattern.compile(loginAndPasswordFormat);
        Matcher nameMatcher = pattern.matcher(login);
        Matcher passwordMatcher = pattern.matcher(password);

        boolean isUserExist;
        boolean isDone = false;

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
                isDone = true;
            } catch (DAOException e) {
                throw new ServiceException(e);
            }
        }

        return isDone;
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
    public boolean setUserRank(String login, Double rank) throws ServiceException {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        DAOFactory daoFactory = DAOFactory.getInstance();
        boolean isUserExist = serviceFactory.getUserService().isUserExist(login);
        boolean isDone = false;

        if (isUserExist) {
            try {
                daoFactory.getUserDAO().setUserRank(login, rank);
                isDone = true;
            } catch (DAOException e) {
                throw new ServiceException(e);
            }
        }

        return isDone;
    }

    @Override
    public List<User> users() throws ServiceException {
        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            return daoFactory.getUserDAO().users();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void autoRank() throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        List<Movie> movies;
        List<String> users = new ArrayList<>();
        List<MovieReview> movieReviewList;
        int count = 0;

        try {
            movieReviewList = daoFactory.getMovieReviewDAO().movieReviews();
            movies = daoFactory.getMovieDAO().movies();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        for (Movie movie : movies) {
            for (MovieReview movieReview : movieReviewList) {
                if (movieReview.getMovie().equalsIgnoreCase(movie.getTitle())) {
                    count = count + 1;
                    users.add(movieReview.getUser());
                }
                if (count >= 5) {
                    for (String user : users) {
                        double movieRank;
                        double userMark;
                        movieRank = serviceFactory.getMovieReviewService().movieRating(movieReview.getMovie());
                        userMark = movieReview.getMark();

                        double result = Math.abs(movieRank - userMark);

                        if (result >= 0 & result < 1) {
                            serviceFactory.getUserService().setUserRank(user, 10.0);
                        } else if (result >= 1 & result < 2) {
                            serviceFactory.getUserService().setUserRank(user, 8.0);
                        } else if (result >= 2 & result < 3) {
                            serviceFactory.getUserService().setUserRank(user, 6.0);
                        } else if (result >= 3 & result < 4) {
                            serviceFactory.getUserService().setUserRank(user, 4.0);
                        } else if (result >= 4 & result < 5) {
                            serviceFactory.getUserService().setUserRank(user, 2.0);
                        } else if (result >= 5 & result < 6) {
                            serviceFactory.getUserService().setUserRank(user, 0.0);
                        } else if (result >= 6 & result < 7) {
                            serviceFactory.getUserService().setUserRank(user, -2.0);
                        } else if (result >= 7 & result < 8) {
                            serviceFactory.getUserService().setUserRank(user, -4.0);
                        } else if (result >= 8 & result < 9) {
                            serviceFactory.getUserService().setUserRank(user, -6.0);
                        } else {
                            serviceFactory.getUserService().setUserRank(user, -8.0);
                        }
                    }
                }

            }
            count = 0;
            users().clear();
        }

    }

    @Override
    public boolean isUserInBan(String login) throws ServiceException {
        boolean isUserInBan;

        DAOFactory daoFactory = DAOFactory.getInstance();

        try {
            int userRoleID = daoFactory.getUserDAO().userRoleID(login);
            if (userRoleID == 3) {
                isUserInBan = true;
            } else {
                isUserInBan = false;
            }
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return isUserInBan;

    }

    @Override
    public boolean banUser(String login) throws ServiceException {
        boolean isDone;

        DAOFactory daoFactory = DAOFactory.getInstance();
        try {
            daoFactory.getUserDAO().banUser(login);
            isDone = true;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }

        return isDone;
    }
}
