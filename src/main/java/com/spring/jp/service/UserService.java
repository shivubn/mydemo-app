package com.spring.jp.service;

import com.spring.jp.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();
    User getUserById(Long id);
    void deleteByUserId(Long id);
    User createUser(User user);
}
