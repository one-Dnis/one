package com.company.example.movies;


import com.company.example.movies.dao.*;
import com.company.example.movies.dao.connectionpool.ConnectionPoolException;
import com.company.example.movies.dao.impl.MovieDAOImpl;
import com.company.example.movies.dao.impl.MovieReviewDAOImpl;
import com.company.example.movies.dao.impl.UserDAOImpl;
import com.company.example.movies.service.ServiceException;
import com.company.example.movies.service.ServiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

public class Main {

    private static final Logger logger= LoggerFactory.getLogger(Main.class.getSimpleName());

    public static void main(String[] args) throws SQLException, ConnectionPoolException, DAOException, ServiceException {
        String message = "MESSAGE";
        logger.debug("ТЕСТ 1 ЛОГГЕРА");
        logger.debug("ТЕСТ 2 ЛОГГЕРА");
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
        ServiceFactory serviceFactory = ServiceFactory.getInstance();


        //проверка на баны
        /*System.out.println(daoFactory.getUserDAO().userRoleID("user7"));
        System.out.println(serviceFactory.getUserService().isUserInBan("user7"));*/

        //забанить юзера
        //serviceFactory.getUserService().banUser("user7");

        //пользователи и фильмы по ID РАБОТАЕТ
        /*System.out.println(daoFactory.getUserDAO().userID("user7"));
        System.out.println(daoFactory.getMovieDAO().movieID("Терминатор"));*/

        //изменить ранк РАБОТАЕТ
        //daoFactory.getUserDAO().setUserRank("user1", 10);

        //проверка форматов
        /*String loginAndPasswordFormat = "[a-zA-Z0-9]+";
        Pattern pattern = Pattern.compile(loginAndPasswordFormat);
        Matcher nameMatcher = pattern.matcher("vASYA4747");
        Matcher passwordMatcher = pattern.matcher("вася123123sasasa");
        System.out.println(nameMatcher.matches());
        System.out.println(passwordMatcher.matches());*/

        //авторизация РАБОТАЕТ
        /*System.out.println(userDAO.authorization("user1", "user1"));*/

        //добавить отзыв
       //System.out.println(serviceFactory.getMovieReviewService().newReview(7.0, "текст текст","user5","Терминатор"));

        //получить рейтинг
        /*String title = "Терминатор";
        double result = serviceFactory.getMovieReviewService().movieRating(title);
        //System.out.println(serviceFactory.getMovieReviewService().movieReviews(title));
        System.out.println(result);
*/
        //список ревьюшек РАБОТАЕТ
        /*List<MovieReview> movieReviews = movieReviewDAO.movieReviews();
        System.out.println(movieReviews.toString());*/

        /*//список стран по id
        Map<Integer, Country> countries = countryDAO.countries();
        System.out.println(countries.toString());*/

        //добавить юзера РАБОТАЕТ
        //daoFactory.getUserDAO().newUser("user5", "user5", "не Вася 5");

        //isUserExists работает
        /*String userName = "admin";
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        boolean flag1 = serviceFactory.getUserService().isUserExist(userName);
        boolean flag2 = daoFactory.getUserDAO().isUserExists(userName);
        System.out.println(flag1);
        System.out.println(flag2);*/

        //isMovieExists работает частично
        /*String movieName = "Терминатор";
        serviceFactory = ServiceFactory.getInstance();
        //boolean flag1 = serviceFactory.getUserService().isUserExist(userName);
        boolean flag2 = daoFactory.getMovieDAO().isMovieExists(movieName);
        //System.out.println(flag1);
        System.out.println(flag2);*/

        //isMovieReviewExists работает частично
        /*String movieName = "Список Шиндлера";
        String userName = "user3";
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        //boolean flag1 = serviceFactory.getUserService().isUserExist(userName);
        boolean flag2 = daoFactory.getMovieReviewDAO().isReviewExists(userName, movieName);
        //System.out.println(flag1);
        System.out.println(flag2);*/

        //serviceFactory.getUserService().registration(login, password, info);



        //список пользователей РАБОТАЕТ
        /*List<User> users = userDAO.users();
            System.out.println(users.toString());*/

        /*Map<String, Movie> movies = movieDAO.movies();
        System.out.println((movies.toString()).toString());*/

        //изменить фильм РАБОТАЕТ
        //System.out.println(daoFactory.getMovieDAO().editMovie("Дневники вампира","Дневники вампира", 2, 2009, ""));
        //добавить фильм РАБОТАЕТ по новому
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
