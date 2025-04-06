package com.spring_sercurity.repo;

import com.spring_sercurity.dto.StudentDTO;
import com.spring_sercurity.entity.Student;
import com.spring_sercurity.entity.UserMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
    public List<Student> findAllByCreatedBy(UserMaster username);
}
