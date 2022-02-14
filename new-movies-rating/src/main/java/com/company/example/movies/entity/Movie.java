package com.company.example.movies.entity;

import java.util.List;
import java.util.Objects;

public class Movie {

    private int id;
    private String type;
    private String title;
    private int year;
    private double rating;
    private String country;
    private List<String> category;
    private String shortDescription;
    private List<Person> persons;

    public Movie() {
    }

    public Movie(int id, String type, String title, int year, double rating, String country, List<String> category, String shortDescription, List<Person> persons) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.country = country;
        this.category = category;
        this.shortDescription = shortDescription;
        this.persons = persons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && year == movie.year && Double.compare(movie.rating, rating) == 0 && type.equals(movie.type) && title.equals(movie.title) && country.equals(movie.country) && category.equals(movie.category) && shortDescription.equals(movie.shortDescription) && persons.equals(movie.persons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, title, year, rating, country, category, shortDescription, persons);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", country='" + country + '\'' +
                ", category=" + category +
                ", shortDescription='" + shortDescription + '\'' +
                ", persons=" + persons +
                '}';
    }
}
