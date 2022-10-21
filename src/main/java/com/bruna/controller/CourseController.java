package com.bruna.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @GetMapping("/{id}")
  public ResponseEntity<Courses> findById(@PathVariable Long id) {
    return coursesRepository.findById(id)
        .map(recordFound -> ResponseEntity.ok().body(recordFound))
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public Courses create(@RequestBody Courses Record) {
    return coursesRepository.save(Record);
    // System.out.println(Record.getName());
    // return ResponseEntity.status(HttpStatus.CREATED)
    // .body(coursesRepository.save(Record));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Courses> update(@PathVariable Long id, @RequestBody Courses course) {
    return coursesRepository.findById(id)
        .map(recordFound -> {
          recordFound.setName(course.getName());
          recordFound.setCategory(course.getCategory());
          Courses updated = coursesRepository.save(recordFound);
          return ResponseEntity.ok().body(updated);
        })
        .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    return coursesRepository.findById(id)
        .map(recordFound -> {
          coursesRepository.deleteById(id);
          return ResponseEntity.noContent().<Void>build();
        })
        .orElse(ResponseEntity.notFound().build());
  }
}
