package com.company.example.movies.controller.impl;

import com.company.example.movies.controller.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EndSessionCommand implements Command {

    private static final Logger logger= LoggerFactory.getLogger(EndSessionCommand.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute("userName");
        session.removeAttribute("role");


        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mainPage.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            logger.error("ошибка при попытке завершить сессию и перейти на mainPage.jsp", e);
        }
    }
}
