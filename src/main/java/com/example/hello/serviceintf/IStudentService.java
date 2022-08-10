package com.example.hello.serviceintf;

import com.example.hello.dto.Student;

import java.util.List;
public interface IStudentService {

    void save(Student student);

    boolean deleteById(int sid);

    Student getById(int sid);

    boolean update(Student student);

    List<Student> getAllStudents();
}
