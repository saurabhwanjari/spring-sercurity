package com.spring_sercurity.service;

import com.spring_sercurity.entity.UserMaster;
import com.spring_sercurity.mapper.StudentDtoMapper;
import com.spring_sercurity.repo.StudentRepo;
import com.spring_sercurity.repo.UserMasterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserMasterService {
    private BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder(12);
    @Autowired
    UserMasterRepo userMasterRepo;

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTService jwtService;


    private final StudentDtoMapper studentMapper;

    public UserMasterService(StudentDtoMapper studentMapper) {
        this.studentMapper=studentMapper;
    }

    public UserMaster registerUser(UserMaster user){
        user.setPassword(bCrypt.encode(user.getPassword()));
        return userMasterRepo.save(user);
    }

    public String authenticateUser(UserMaster user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

       if( authentication.isAuthenticated())
           return jwtService.generateToken(user.getUsername());

       return "fail";
    }



}
