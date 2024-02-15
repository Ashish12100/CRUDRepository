package com.example.CsvDemo.service.Implementation;

import com.example.CsvDemo.entity.Student;
import com.example.CsvDemo.repository.StudentRepository;
import com.example.CsvDemo.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void createStudentService(Student student) {
        studentRepository.save(student);
    }



    @Override
    public void deleteStudentService(Integer Id) {

        studentRepository.deleteById(Id);

    }

    @Override
    public Student getStudentService(Integer Id) {
        return studentRepository.findById(Id).get();
    }

    @Override
    public List<Student> getAllStudentDetails() {
        return studentRepository.findAll();
    }



    @Override
    public void updateStudentService(Student student) {
        studentRepository.save(student);


    }



}


