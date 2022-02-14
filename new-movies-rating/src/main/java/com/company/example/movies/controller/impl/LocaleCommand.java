package com.company.example.movies.controller.impl;

import com.company.example.movies.controller.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LocaleCommand implements Command {

    private static final Logger logger= LoggerFactory.getLogger(LocaleCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
       // request.getSession(true).setAttribute("locale", request.getParameter("locale"));

        HttpSession session = request.getSession();
        String locale = request.getParameter("locale");

        session.setAttribute("locale", locale);

        try {
            request.getRequestDispatcher("/WEB-INF/jsp/mainPage.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            logger.error("ошибка при попытке перейти на mainPage.jsp", e);
        }
    }
}
