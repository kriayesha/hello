package com.example.hello;

import com.example.hello.dto.Student;
import com.example.hello.entity.StudentEntity;
import com.example.hello.repositoryintf.IStudentRepo;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

import org.assertj.core.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
//@DataJpaTest
class HelloApplicationTests {

	@Autowired
	IStudentRepo studentRepo;

	private StudentEntity student;

	private MockMvc mockMvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	@BeforeEach
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		student = new StudentEntity();
		student.setsName("Hello");
		student.setContactNo(1234567890L);
		student.setAge(23);
	}

	@Test
	void contextLoads() {
	}

	@Test
	void save_By_Repo(){
//studentController.createStudentData(s)
		StudentEntity student1 = studentRepo.save(student);
		assertThat(student1).isNotNull();
		assertThat(student1.getSid()).isGreaterThan(0);
//assertThat(student1.getSid()).isEqualTo(0);
	}

	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}
	protected <T> T mapFromJson(String json, Class<T> clazz)
			throws  IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}
	@Test
	void test_save_from_controller() throws Exception {
		String uri = "/student/save";
		Student student1 = new Student();
		student1.setsName("Raghav");
		student1.setAge(21);
		student1.setContactNo(1223334444L);
		String inputJson = mapToJson(student1);
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON).content(inputJson)).andReturn();
		int status =mvcResult.getResponse().getStatus();
		assertEquals(202 , status);
	}

	@Test
	void delete(){
//studentRepo.f
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
