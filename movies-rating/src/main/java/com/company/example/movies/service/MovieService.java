package com.company.example.movies.service;
import com.company.example.movies.entity.Movie;
import java.util.List;

public interface MovieService {

    List<Movie> movies() throws ServiceException;

}
