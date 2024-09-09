package com.booleanuk.api.authors;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {
  // Spec technically specifies snake_case, but that is not the convention for
  // json so I will do it in camelcase anyways
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column
  @JsonProperty(required = true)
  private String firstName;

  @Column
  @JsonProperty(required = true)
  private String lastName;

  @Column
  @JsonProperty(required = true)
  private String email;

  @Column
  @JsonProperty(required = true)
  private boolean alive;
}
