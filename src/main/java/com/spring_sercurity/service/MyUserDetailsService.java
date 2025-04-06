package com.spring_sercurity.service;

import com.spring_sercurity.entity.UserMaster;
import com.spring_sercurity.entity.UserPrincipal;
import com.spring_sercurity.repo.UserMasterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserMasterRepo userMasterRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserMaster> user = userMasterRepo.findByUsername(username);

        if(user.isEmpty()){
            System.out.println("User not found");
            throw new UsernameNotFoundException ("user not found");
        }
        System.out.println("username ::"+user.toString());
        return new UserPrincipal(user.get());
    }
}
