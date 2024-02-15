package com.example.CsvDemo.service;

import com.example.CsvDemo.entity.Student;

import java.util.List;

public interface StudentService {

    void createStudentService(Student student);

    void deleteStudentService(Integer Id);
    Student getStudentService(Integer Id);
    List<Student> getAllStudentDetails();


    void updateStudentService(Student student);



}
