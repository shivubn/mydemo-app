package com.spring.jp.service;

import com.spring.jp.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    List<User> users = new ArrayList<>();

    public UserServiceImpl() {
        users.add(new User(1L, "Jp", "J", "jp@yahoo.com"));
        users.add(new User(2L, "GOkul", "Nandan", "Gokul@yahoo.com"));
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User getUserById(Long id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().get();
    }

    @Override
    public User createUser(User user) {
        Optional<User> optUser = users.stream().filter(u -> u.getId() == user.getId()).findFirst();
        if (optUser.isPresent()) {
            User oldUser = optUser.get();
            oldUser.setEmail(user.getEmail());
            oldUser.setFirstName(user.getFirstName());
            oldUser.setLastName(user.getLastName());
        } else {
            Long maxId = users.stream().max(Comparator.comparing(User::getId)).get().getId();
            maxId = maxId + 1;
            user.setId(maxId);
            users.add(user);
        }
       return user;
    }

    @Override
    public void deleteByUserId(Long id) {
        users.removeIf(user -> user.getId() == id);
    }
}
