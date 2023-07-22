package com.system.user.dao;

import com.system.user.models.User;

import java.util.List;

public interface UserDao {
    List<User> getUser();
}