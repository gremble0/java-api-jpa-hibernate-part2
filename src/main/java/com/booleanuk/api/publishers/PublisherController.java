package com.booleanuk.api.publishers;

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
@RequestMapping("publishers")
public class PublisherController {
  private final PublisherRepository repository;

  public PublisherController(PublisherRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public ResponseEntity<List<Publisher>> get() {
    return ResponseEntity.ok(this.repository.findAll());
  }

  @GetMapping
  public ResponseEntity<Publisher> get(@PathVariable int id) {

  }

  @PostMapping
  public ResponseEntity<Publisher> post(@RequestBody Publisher publisher) throws ResponseStatusException {
    try {
      return ResponseEntity.status(HttpStatus.CREATED).body(this.repository.save(publisher));
    } catch (DataIntegrityViolationException e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not create author");
    }
  }
}
