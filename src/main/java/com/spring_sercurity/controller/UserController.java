package com.spring_sercurity.controller;

import com.spring_sercurity.entity.Student;
import com.spring_sercurity.entity.UserMaster;
import com.spring_sercurity.service.UserMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMasterService userMasterService;

    @PostMapping("/registerUser")
    public UserMaster registerUser (@RequestBody  UserMaster user){
        return userMasterService.registerUser(user);
    }

    @PostMapping("/login")
    public String loginUser (@RequestBody  UserMaster user){
        return userMasterService.authenticateUser(user);
    }

}
