package com.company.example.movies;


import com.company.example.movies.controller.ControllerException;
import com.company.example.movies.dao.*;
import com.company.example.movies.dao.connectionpool.ConnectionPoolException;
import com.company.example.movies.dao.impl.MovieDAOImpl;
import com.company.example.movies.dao.impl.MovieReviewDAOImpl;
import com.company.example.movies.dao.impl.UserDAOImpl;
import com.company.example.movies.entity.Movie;
import com.company.example.movies.entity.MovieReview;
import com.company.example.movies.entity.User;
import com.company.example.movies.service.ServiceException;
import com.company.example.movies.service.ServiceFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws SQLException, ConnectionPoolException, DAOException, ServiceException {
        /*Locale defaultLocale = Locale.getDefault();
        Locale frLocale = new Locale("fr", "FR");

        System.out.println(defaultLocale.getDisplayCountry());
        System.out.println(defaultLocale.getDisplayCountry(Locale.FRENCH));
        System.out.println(frLocale.getDisplayCountry(Locale.ENGLISH));*/

        //from old test
        MovieDAO movieDAO = new MovieDAOImpl();
        UserDAO userDAO = new UserDAOImpl();
        MovieReviewDAO movieReviewDAO = new MovieReviewDAOImpl();
        DAOFactory daoFactory = DAOFactory.getInstance();

        //проверка форматов
        /*String loginAndPasswordFormat = "[a-zA-Z0-9]+";
        Pattern pattern = Pattern.compile(loginAndPasswordFormat);
        Matcher nameMatcher = pattern.matcher("vASYA4747");
        Matcher passwordMatcher = pattern.matcher("вася123123sasasa");
        System.out.println(nameMatcher.matches());
        System.out.println(passwordMatcher.matches());*/

        //авторизация РАБОТАЕТ
        /*System.out.println(userDAO.authorization("user1", "user1"));*/

        //список ревьюшек РАБОТАЕТ
        /*List<MovieReview> movieReviews = movieReviewDAO.movieReviews();
        System.out.println(movieReviews.toString());*/

        /*//список стран по id
        Map<Integer, Country> countries = countryDAO.countries();
        System.out.println(countries.toString());*/

        //добавить юзера РАБОТАЕТ
        //daoFactory.getUserDAO().newUser("user5", "user5", "не Вася 5");

        String userName = "user1";
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        boolean flag1 = serviceFactory.getUserService().isUserExist(userName);
        boolean flag2 = daoFactory.getUserDAO().isUserExists(userName);
        System.out.println(flag1);
        System.out.println(flag2);

                //serviceFactory.getUserService().registration(login, password, info);



        //список пользователей РАБОТАЕТ
        /*List<User> users = userDAO.users();
            System.out.println(users.toString());*/

        /*Map<String, Movie> movies = movieDAO.movies();
        System.out.println((movies.toString()).toString());*/



        //добавить фильм РАБОТАЕТ добавить ключи
        /*Movie newMovie = new Movie(0,"Дневники вампира", 2009, "сериал о Деймоне", 0);
        movieDAO.addMovie(newMovie);*/

        //movieDAO.deleteMovie(7, "Престиж"); //не работает





        //для тестов

        /*Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/movies_rating?useUnicode=true&serverTimezone=UTC&useSSL=false","root", "4fgb");

        System.out.println("ОК");

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM movies");

        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " +
            rs.getString(2) + " " +
            rs.getInt(3) + " " +
            rs.getString(4));
        }

        rs.close();
        st.close();
        con.close();*/




        /*ConnectionPoolAccess connectionPoolAccess = new ConnectionPoolAccess();

        Connection connection = connectionPoolAccess.getConnection();


        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM movies");

        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " +
                    rs.getString(2) + " " +
                    rs.getInt(3) + " " +
                    rs.getString(4));
        }*/
    }
}
