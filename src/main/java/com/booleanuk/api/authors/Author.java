package com.booleanuk.api.authors;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.booleanuk.api.books.Book;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authors")
public class Author {
  // Spec technically specifies snake_case, but that is not the convention for
  // json so I will do it in camelcase anyways
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false)
  @JsonProperty(required = true)
  private String firstName;

  @Column(nullable = false)
  @JsonProperty(required = true)
  private String lastName;

  @Column(nullable = false)
  @Email
  @JsonProperty(required = true)
  private String email;

  @Column(nullable = false)
  @JsonProperty(required = true)
  private Boolean alive;

  @OneToMany
  @JoinColumn(name = "author_id")
  @JsonManagedReference
  private List<Book> books;
}
