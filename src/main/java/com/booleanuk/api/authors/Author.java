package com.booleanuk.api.authors;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {
  // Spec technically specifies snake_case, but that is not the convention for
  // json so I will do it in camelcase anyways
  @Column
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column
  private String firstName;

  @Column
  private String lastName;

  @Column
  private String email;

  @Column
  private boolean alive;
}
