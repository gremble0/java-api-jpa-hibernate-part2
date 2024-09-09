package com.booleanuk.api.books;

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
@RequestMapping("books")
public class BookController {
  private final BookRepository repository;

  public BookController(BookRepository repository) {
    this.repository = repository;
  }

  @PostMapping
  public ResponseEntity<Book> post(@RequestBody Book book) throws ResponseStatusException {
    try {
      return ResponseEntity.status(HttpStatus.CREATED).body(this.repository.save(book));
    } catch (DataIntegrityViolationException e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not create book");
    }
  }

  @GetMapping
  public ResponseEntity<List<Book>> get() {
    return ResponseEntity.ok(this.repository.findAll());
  }

  @GetMapping(value = "{id}")
  public ResponseEntity<Book> get(@PathVariable int id) throws ResponseStatusException {
    return this.repository.findById(id)
        .map(ResponseEntity::ok)
        .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No book with id '" + id + "' exists"));
  }
}
