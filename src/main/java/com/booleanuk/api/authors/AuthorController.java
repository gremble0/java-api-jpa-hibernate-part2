package com.booleanuk.api.authors;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("authors")
public class AuthorController {
  private final AuthorRepository repository;

  public AuthorController(AuthorRepository repository) {
    this.repository = repository;
  }

  @PostMapping
  public ResponseEntity<Author> post(@RequestBody Author author) throws ResponseStatusException {
    try {
      return new ResponseEntity<>(this.repository.save(author), HttpStatus.CREATED);
    } catch (DataIntegrityViolationException e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not create author");
    }
  }

  @GetMapping
  public ResponseEntity<List<Author>> get() {
    return new ResponseEntity<>(this.repository.findAll(), HttpStatus.OK);
  }

  @GetMapping(value = "{id}")
  public ResponseEntity<Author> get(@PathVariable int id) {
    return null;
  }
}
