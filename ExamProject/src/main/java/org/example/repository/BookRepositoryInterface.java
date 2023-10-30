package org.example.repository;


import org.example.entity.Author;
import org.example.entity.Book;

public interface BookRepositoryInterface {
    String saveBook(Book book);
    Author updateBookAuthor(Long bookID, Long authorId, Author newAuthor);
    Book getBookAndPublisherByBookId(Long bookID);
    String deleteBookByAuthorId(Long authorID, Long bookID);
}
