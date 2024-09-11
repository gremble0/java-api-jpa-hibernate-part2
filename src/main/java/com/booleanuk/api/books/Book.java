package com.booleanuk.api.books;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.booleanuk.api.authors.Author;
import com.booleanuk.api.publishers.Publisher;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String genre;

  @ManyToOne
  @JsonIncludeProperties(value = {"id", "first_name", "last_name", "email", "alive"})
  @JoinColumn(name = "author_id")
  private Author author;

  @ManyToOne
  @JsonIncludeProperties(value = {"id", "name", "location"})
  @JoinColumn(name = "publisher_id")
  private Publisher publisher;
}
