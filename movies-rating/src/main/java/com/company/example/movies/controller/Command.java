package com.company.example.movies.controller;

import com.company.example.movies.dao.DAOException;
import com.company.example.movies.dao.connectionpool.ConnectionPoolException;
import com.company.example.movies.service.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public interface Command {

    void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException, ControllerException;
}
