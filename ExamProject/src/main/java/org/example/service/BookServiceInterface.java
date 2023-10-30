package org.example.service;

import org.example.entity.Author;
import org.example.entity.Book;

public interface BookServiceInterface {
    String saveBook(Book book);
    Author updateBookAuthor(Long bookID, Long authorId, Author newAuthor);
    Book getBookAndPublisherByBookId(Long bookID);
    String deleteBookByAuthorId(Long authorID, Long bookID);
}
