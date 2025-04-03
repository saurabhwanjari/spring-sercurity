package com.spring_sercurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import  com.spring_sercurity.entity.Users;

@Repository
public interface UserRepo extends JpaRepository<Users,Long> {
    public Users findByUsername(String username);
}
