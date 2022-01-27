package com.company.example.movies.dao;



import com.company.example.movies.dao.connectionpool.ConnectionPoolException;
import com.company.example.movies.entity.Movie;

import java.sql.SQLException;
import java.util.List;

public interface MovieDAO {

    boolean addMovie(Movie movie) throws DAOException;
    boolean deleteMovie(String title) throws DAOException;
    boolean editMovie(Movie movie) throws DAOException;;
    List<Movie> movies() throws DAOException;

}
