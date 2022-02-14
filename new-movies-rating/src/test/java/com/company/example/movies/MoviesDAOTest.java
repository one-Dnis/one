package com.company.example.movies;

import com.company.example.movies.dao.DAOException;
import com.company.example.movies.dao.DAOFactory;
import com.company.example.movies.dao.impl.UserDAOImpl;
import com.company.example.movies.entity.Movie;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.opentest4j.TestAbortedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class MoviesDAOTest {

    private static final Logger logger = LoggerFactory.getLogger(MoviesDAOTest.class);

    @BeforeClass
    public static void start() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        List<Movie> movieList = null;
        try {
            movieList = daoFactory.getMovieDAO().movies();
        } catch (DAOException e) {
            logger.error("DAOException", e);
        }
    }

    @Test
    public void testMoviesList() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        List<Movie> movieList = null;
        try {
            movieList = daoFactory.getMovieDAO().movies();
        } catch (DAOException e) {
            logger.error("DAOException", e);
        }

        Assert.assertTrue(movieList.size() > 0);

    }

}



