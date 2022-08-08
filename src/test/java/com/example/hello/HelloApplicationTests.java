package com.example.hello;

import com.example.hello.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloApplicationTests {

	@Autowired
	StudentController studentController;

	@Test
	void contextLoads() {
	}

	@Test
	void save(){
//studentController.createStudentData(s)
	}

	@Test
	void delete(){

	}

	@Test
	void update(){

	}

	@Test
	void fetch(){

	}

	@Test
	void getAll(){

	}

}
