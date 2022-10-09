package com.bruna.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

// classe q monata tabela no banco de dados 
@Data
@Entity
public class Courses {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  // tranforma o nome dessa propriedade no json do response
  @JsonProperty("_id")
  private long id;

  @Column(length = 200, nullable = false)
  private String name;

  @Column(length = 10, nullable = false)
  private String category;
}
