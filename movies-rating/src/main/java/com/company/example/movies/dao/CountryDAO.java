package com.company.example.movies.dao;

import com.company.example.movies.dao.connectionpool.ConnectionPoolException;
import com.company.example.movies.entity.Country;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface CountryDAO {

    void addCountry(String name);
    void deleteCountry(String name);
    List<Country>countries() throws DAOException;
}
