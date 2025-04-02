package com.spring_sercurity.controller;

import com.spring_sercurity.entity.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.css.CSSFontFaceRule;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    List<Student>students = new ArrayList<>(List.of(
            new Student(1L,"saurabh","1"),
            new Student(2L,"niraj","2"),
            new Student(3L,"shubham","3")
    ));

    @GetMapping("/")
    public String Greet (HttpServletRequest request){
        return "Hello World :"+ request.getSession().getId();
    }

    @GetMapping("/getStudents")
    public List<Student>getStudents(){
        return students;
    }

    @PostMapping("/createStudent")
    public Student createStudents(@RequestBody Student std ){
        students.add(std);
        return std;
    }

    @GetMapping("/getCsrf")
    public CsrfToken getCsrftoken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}




