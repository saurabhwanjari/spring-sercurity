package com.spring_sercurity.controller;

import com.spring_sercurity.entity.Users;
import com.spring_sercurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/registerUser")
    public Users registerUser (@RequestBody  Users user){
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String loginUser (@RequestBody  Users user){

        return userService.authenticateUser(user);
//        return "Login Successfully ";
    }
}
