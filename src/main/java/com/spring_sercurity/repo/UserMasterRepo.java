package com.spring_sercurity.repo;

import com.spring_sercurity.entity.UserMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserMasterRepo extends JpaRepository<UserMaster,Long> {
    public Optional<UserMaster> findByUsername(String username);
}
