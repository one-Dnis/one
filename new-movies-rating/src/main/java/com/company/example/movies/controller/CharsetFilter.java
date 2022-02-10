package com.company.example.movies.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class CharsetFilter implements Filter {
    private static final Logger logger= LoggerFactory.getLogger(CharsetFilter.class);
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) {
        logger.debug("CharsetFilter is started");
        encoding = filterConfig.getInitParameter("requestEncoding");
        if(encoding==null) encoding="utf-8";
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        try {
            servletRequest.setCharacterEncoding(encoding);
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (ServletException | IOException e) {
            logger.error("CharsetFilter:error", e);
        }
    }

    @Override
    public void destroy() {

    }
}
