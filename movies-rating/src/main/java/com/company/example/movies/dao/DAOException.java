package com.company.example.movies.dao;

public class DAOException extends Exception {

    public DAOException() {
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable e) {
        super(message, e);
    }

    public DAOException(Throwable e) {
        super(e);
    }
}
