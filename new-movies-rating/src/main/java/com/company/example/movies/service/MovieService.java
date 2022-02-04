package com.company.example.movies.service;
import com.company.example.movies.entity.Movie;
import java.util.List;

public interface MovieService {

    List<Movie> movies() throws ServiceException;
    boolean newMovie(String title, String type, int year, String shortDescription) throws ServiceException;
    boolean editMovie(String title, String newTitle, String type, int year, String shortDescription) throws ServiceException;
    boolean deleteMovie(String title) throws ServiceException;
    //double movieRating();
}
