package com.booleanuk.api.books;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
  @JsonProperty(required = true)
  private String title;

  @Column(nullable = false)
  @JsonProperty(required = true)
  private String genre;

  @Column(nullable = false)
  @JsonProperty(required = true)
  private int authorId;

  @Column(nullable = false)
  @JsonProperty(required = true)
  private int publisherId;
}
