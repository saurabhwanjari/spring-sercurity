package com.spring_sercurity.service;

import com.spring_sercurity.entity.Users;
import com.spring_sercurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    public Users registerUser(Users user){
        return userRepo.save(user);
    }
}
