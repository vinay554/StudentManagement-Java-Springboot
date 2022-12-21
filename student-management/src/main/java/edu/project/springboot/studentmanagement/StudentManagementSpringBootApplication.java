package edu.project.springboot.studentmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan(basePackages={"edu.project.springboot.studentmanagement.*"})
public class StudentManagementSpringBootApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSpringBootApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
		
	}
}
