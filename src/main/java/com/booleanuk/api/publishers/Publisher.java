package com.booleanuk.api.publishers;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.booleanuk.api.books.Book;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "publishers")
public class Publisher {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String location;

  @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonIgnoreProperties("publisher")
  private List<Book> books;
}