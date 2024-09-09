package com.booleanuk.api.authors;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authors")
public class AuthorController {
  private final AuthorRepository repository;

  public AuthorController(AuthorRepository repository) {
    this.repository = repository;
  }

  @PostMapping
  public Author post(@RequestBody Author author) {
    return this.repository.save(author);
  }
}
