package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

@Controller
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    @ResponseBody
    public String getUsers() {
        List<User> users = userRepository.getUsers();
        String response = "";
        for (User user : users) {
            response += user.toString();
            response += "</br>";
        }
        return response;
    }

    @GetMapping("/add")
    @ResponseBody
    public String saveUser(@RequestParam String name,
                           @RequestParam String lastname,
                           @RequestParam double age) {
        //System.out.println(name + " " + lastname + " " + age);
        User user = new User(name, lastname, age);
        userRepository.getUsers().add(user);
        System.out.println("Zapisano");

        return "abc";
    }
}
