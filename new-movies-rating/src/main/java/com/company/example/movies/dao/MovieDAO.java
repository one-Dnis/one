package com.company.example.movies.dao;


import com.company.example.movies.entity.Movie;
import java.util.List;

public interface MovieDAO {

    boolean newMovie(String title, int year, int typeID, String shortDescription) throws DAOException;
    boolean deleteMovie(String title) throws DAOException;
    boolean editMovie(String title, String newTitle, int typeID, int year, String shortDescription) throws DAOException;
    List<Movie> movies() throws DAOException;
    boolean isMovieExists(String title) throws DAOException;
    int movieID(String title) throws DAOException;

}
