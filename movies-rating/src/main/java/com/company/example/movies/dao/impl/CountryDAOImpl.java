package com.company.example.movies.dao.impl;


import com.company.example.movies.dao.CountryDAO;
import com.company.example.movies.dao.DAOException;
import com.company.example.movies.dao.connectionpool.ConnectionPoolAccess;
import com.company.example.movies.dao.connectionpool.ConnectionPoolException;
import com.company.example.movies.entity.Country;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountryDAOImpl implements CountryDAO {
    @Override
    public void addCountry(String name) {

    }

    @Override
    public void deleteCountry(String name) {

    }

    @Override
    public List<Country> countries() throws DAOException {

        List<Country> countries = new ArrayList<>();

        /*ConnectionPoolAccess connectionPoolAccess = new ConnectionPoolAccess();
        Connection connection = connectionPoolAccess.getConnection();

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT movies_rating.country.id, movies_rating.country.title FROM movies_rating.country");

        while (rs.next()) {

            Country country = new Country();

            country.setId(rs.getInt(1));
            country.setName(rs.getString(2));

            countries.add(country);
        }*/

        return countries;
    }


}
