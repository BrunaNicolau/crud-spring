package com.bruna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bruna.model.Courses;
import com.bruna.repository.CoursesRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

  @Autowired
  private final CoursesRepository coursesRepository;

  @GetMapping
  public List<Courses> list() {
    return coursesRepository.findAll();
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public Courses create(@RequestBody Courses Record) {
    return coursesRepository.save(Record);
    // System.out.println(Record.getName());
    // return ResponseEntity.status(HttpStatus.CREATED)
    // .body(coursesRepository.save(Record));
  }
}
