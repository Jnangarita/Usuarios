package com.system.user.dao;

import com.system.user.models.User;

import java.util.List;

public interface UserDao {
    List<User> getUser();

    void delete(int id);

    void register(User user);
}