package com.bruna;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bruna.model.Courses;
import com.bruna.repository.CoursesRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(CoursesRepository coursesRepository) {
		return args -> {
			coursesRepository.deleteAll();

			Courses c = new Courses();
			c.setName("Angular com Spring");
			c.setCategory("front-end");

			coursesRepository.save(c);
		};
	}

}
