package com.spring_sercurity.entity;


public class Student {
    Long id;
    String studentName;
    String rollNo;

    public Student(Long id, String studentName, String rollNo) {
        this.id = id;
        this.studentName = studentName;
        this.rollNo = rollNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }
}
