package com.company.example.movies.service;


import com.company.example.movies.entity.MovieReview;

import java.util.List;

public interface MovieReviewService {
    double movieRating(String title) throws ServiceException;
    boolean newReview(Double mark, String movieReview, String user, String movie) throws ServiceException;
    List<MovieReview> movieReviews(String movie) throws ServiceException;
}
