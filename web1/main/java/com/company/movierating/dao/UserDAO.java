package com.company.movierating.dao;

import com.company.movierating.entity.User;

public interface UserDAO {

    void signIn(String login, String password);
    void registration(User user);

}
