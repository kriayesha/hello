package com.example.hello.serviceimpl;

import com.example.hello.dto.Student;
import com.example.hello.entity.StudentEntity;
import com.example.hello.repositoryintf.IStudentRepo;
import com.example.hello.serviceintf.IStudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepo studentRepo;
    private static final Logger logger = LogManager.getLogger(StudentServiceImpl.class);
    @Override
    public void save(Student student) {
        logger.info("Student to save : " + student);
        StudentEntity student1 = new StudentEntity();
        student1.setsName(student.getsName());
        student1.setAge(student.getAge());
        student1.setContactNo(student.getContactNo());
        logger.info("StudentEntity to save : " + student1);
        studentRepo.save(student1);
//        studentRepo.save(student);
//        return true;
    }

    @Override
    public boolean deleteById(int sid) {
        return false;
    }

    @Override
    public Student getById(int sid) {
        return null;
    }

    @Override
    public boolean update(Student student) {
        return false;
    }

    @Override
    public List<Student> getAllStudents() {
        return null;
    }
}
