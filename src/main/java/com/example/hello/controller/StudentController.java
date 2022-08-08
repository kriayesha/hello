package com.example.hello.controller;

import com.example.hello.dto.Student;
import com.example.hello.serviceimpl.StudentServiceImpl;
import com.example.hello.serviceintf.IStudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    private static final Logger logger = LogManager.getLogger(StudentController.class);

    @PostMapping("/save")
    public ResponseEntity<String> createStudentData(@RequestBody Student student) {
        ResponseEntity<String> responseEntity;
        logger.info("Request received : " + student);
         studentService.save(student);
        responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);
        return responseEntity;
    }
}
