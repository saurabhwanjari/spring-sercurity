package com.spring_sercurity.controller;

import com.spring_sercurity.dto.StudentDTO;
import com.spring_sercurity.entity.Student;
import com.spring_sercurity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/createStudent")
    public Student createStudent (@RequestBody Student student){
        return studentService.createUser(student);
    }

    @GetMapping("/getStudents")
    public List<Student> getStudents(){
        return studentService.getAllStudent();
    }
    @GetMapping("/getStudentById/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }
    @GetMapping("/getStudentById2/{id}")
    public StudentDTO getStudentById2(@PathVariable Long id){
        return studentService.getStudentById2(id);
    }
    @GetMapping("/getStudentById3/{id}")
    public StudentDTO getStudentById3(@PathVariable Long id){
        return studentService.getStudentById3(id);
    }
    @GetMapping("/getAllStudent2")
    public List<StudentDTO> getAllStudentWithDto(){
        return studentService.getAllStudentWithDto();
    }

}
