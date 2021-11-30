package com.company.movierating.entity;

public class Movie {

    private int id;
    private String title;
    private int year;
    private String shortDescription;
    private double rating;

    public Movie() {
    }

    public Movie(int id, String title, int year, String shortDescription, double rating) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.shortDescription = shortDescription;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (id != movie.id) return false;
        if (year != movie.year) return false;
        if (Double.compare(movie.rating, rating) != 0) return false;
        if (!title.equals(movie.title)) return false;
        return shortDescription.equals(movie.shortDescription);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + title.hashCode();
        result = 31 * result + year;
        result = 31 * result + shortDescription.hashCode();
        temp = Double.doubleToLongBits(rating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", shortDescription='" + shortDescription + '\'' +
                ", rating=" + rating +
                '}';
    }
}
