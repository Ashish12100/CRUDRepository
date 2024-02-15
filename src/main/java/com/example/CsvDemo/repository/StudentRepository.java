package com.example.CsvDemo.repository;

import com.example.CsvDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {


    // List<Student> findByAge(int Age);
}