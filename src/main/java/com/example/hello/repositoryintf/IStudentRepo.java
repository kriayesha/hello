package com.example.hello.repositoryintf;

import com.example.hello.dto.Student;
import com.example.hello.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepo extends JpaRepository<StudentEntity,Integer> {

}
