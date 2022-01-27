package com.company.example.movies.entity;

import java.util.Objects;

public class MovieReview {
    private int id;
    private double mark;
    private String review;
    private String movie;
    private String user;

    public MovieReview() {
    }

    public MovieReview(int id, double mark, String review, String movie, String user) {
        this.id = id;
        this.mark = mark;
        this.review = review;
        this.movie = movie;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieReview that = (MovieReview) o;
        return id == that.id && Double.compare(that.mark, mark) == 0 && review.equals(that.review) && movie.equals(that.movie) && user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, review, movie, user);
    }

    @Override
    public String toString() {
        return "MovieReview{" +
                "id=" + id +
                ", mark=" + mark +
                ", review='" + review + '\'' +
                ", movie='" + movie + '\'' +
                ", user='" + user + '\'' +
                '}';
    }
}
