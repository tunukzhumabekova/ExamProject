package org.example.service;

import org.example.entity.Author;

import java.util.List;

public interface AuthorServiceInterface {
    String saveAuthor(Author author);
    Author updateAuthor(Long id, Author newAuthor);
    public List<Author> getAuthorById(Long id);
    List<Author> getAuthorsByPublisherId(Long publisherID);
    String deleteAuthorById(Long id);
}
