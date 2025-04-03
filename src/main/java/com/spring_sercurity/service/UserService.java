package com.spring_sercurity.service;

import com.spring_sercurity.entity.Users;
import com.spring_sercurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder(12);
    @Autowired
    UserRepo userRepo;

    @Autowired
    AuthenticationManager authenticationManager;

    public Users registerUser(Users user){
        user.setPassword(bCrypt.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public String authenticateUser(Users user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

       if( authentication.isAuthenticated())
           return "login";

       return "fail";
    }
}
