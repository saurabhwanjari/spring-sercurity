package com.spring_sercurity.service;

import com.spring_sercurity.dto.StudentDTO;
import com.spring_sercurity.entity.Student;
import com.spring_sercurity.mapper.StudentDtoMapper;
import com.spring_sercurity.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    @Autowired
    StudentDtoMapper stdMapper ;



    public Student createUser(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> getAllStudent() {
        
        return  studentRepo.findAll();
    }

    public List<StudentDTO> getAllStudentWithDto() {
        List<Student> std = studentRepo.findAll();
        return std.stream()
                .map(stdMapper::toDto)
                .collect(Collectors.toList());
    }

    public Student getStudentById(Long id){
        Optional<Student> std= studentRepo.findById(id);
        return std.get();
    }

    public StudentDTO getStudentById2(Long id){
        Optional<Student> std= studentRepo.findById(id);
        return stdMapper.toDto( std.get());
    }
}
