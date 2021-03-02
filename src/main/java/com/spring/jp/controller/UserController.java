package com.spring.jp.controller;

import com.spring.jp.User;
import com.spring.jp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public String getUsers(Model model) {
        List<User> list = userService.getUsers();
        model.addAttribute("users", list);
        return "list-users";
    }

    @GetMapping(path = {"/edit", "/edit/{id}"})
    public String editUserById(Model model, @PathVariable("id") Optional<Long> id) {
        if (id.isPresent()) {
            User user = userService.getUserById(id.get());
            model.addAttribute("user", user);
        } else {
            model.addAttribute("user", new User());
        }
        return "add-edit-user";
    }

    @GetMapping("/user/{id}")
    public String deleteUserById(Model model, @PathVariable("id") Long id) {
        userService.deleteByUserId(id);
        return "redirect:/";
    }

    @PostMapping("/user")
    public String createUser(User user) {
        userService.createUser(user);
        return "redirect:/";
    }
}
