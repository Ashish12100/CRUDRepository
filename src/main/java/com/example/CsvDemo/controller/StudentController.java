package com.example.CsvDemo.controller;

import com.example.CsvDemo.entity.Student;
import com.example.CsvDemo.service.Implementation.StudentServiceImpl;
import com.example.CsvDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/")
public class StudentController {

    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    private final Logger logger = Logger.getLogger("INFO LOGGING");

    @GetMapping("/all")
    public List<Student> getAllStudentDetails() {
        logger.info("To get all the details in the database ");
        return studentService.getAllStudentDetails();
    }

    @PostMapping("/create")
    public String createStudentController(@RequestBody Student student) {
        logger.info("To ppost the details in the database");
        studentService.createStudentService(student);
        return "Success";
    }

    @PutMapping("/update")
    public String updateCloudVendorDetails(@RequestBody Student student){
        logger.info("To update details in the database");
        studentService.updateStudentService(student);
        return "Success";
    }


    @DeleteMapping("/delete/{Id}")
    public String deleteStudentController(@PathVariable Integer Id) {
        logger.info("To delete student details by id");
        studentService.deleteStudentService(Id);
        return "Success";
    }

    @GetMapping("/get/{Id}")
    public Student getStudentById(@PathVariable Integer Id) {
                logger.info("To get details by student id");
             return  studentService.getStudentService(Id);
    }


}