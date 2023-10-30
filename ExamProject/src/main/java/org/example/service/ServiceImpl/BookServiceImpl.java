package org.example.service.ServiceImpl;

import org.example.entity.Author;
import org.example.entity.Book;
import org.example.repository.BookRepositoryInterface;
import org.example.repository.repositoryImpl.BookRepImpl;
import org.example.service.BookServiceInterface;

public class BookServiceImpl implements BookServiceInterface {
    BookRepositoryInterface bookRepository=new BookRepImpl();
    @Override
    public String saveBook(Book book) {
        return bookRepository.saveBook(book);
    }

    @Override
    public Author updateBookAuthor(Long bookID, Long authorId, Author newAuthor) {
        return bookRepository.updateBookAuthor(bookID,authorId,newAuthor);
    }

    @Override
    public Book getBookAndPublisherByBookId(Long bookID) {
        return bookRepository.getBookAndPublisherByBookId(bookID);
    }

    @Override
    public String deleteBookByAuthorId(Long authorID, Long bookID) {
        return bookRepository.deleteBookByAuthorId(authorID,bookID);
    }
}
