package org.example.repository.repositoryImpl;

import org.example.config.Config;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.repository.BookRepositoryInterface;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BookRepImpl implements BookRepositoryInterface {
    Session session = Config.getSession().openSession();
    @Override
    public String saveBook(Book book) {
        session.getTransaction().begin();
        session.merge(book);
        session.getTransaction().commit();
        session.close();
        return "successfully saved";
    }

    @Override
    public Author updateBookAuthor(Long bookID, Long authorId, Author newAuthor) {
        Author author;
        try(Session session = Config.getSession().openSession()){
            Transaction transaction = session.beginTransaction();

            Book book = session.get(Book.class, bookID);
            author = session.get(Author.class, authorId);
            if(author.getId() == book.getAuthors().getId()){
                book.setAuthors(newAuthor);
                session.merge(book);
            }else{
                System.out.println("Данного айди нету");
            }
            transaction.commit();
        }
        return author;
    }

    @Override
    public Book getBookAndPublisherByBookId(Long bookID) {
        session.beginTransaction();
        Book book = session.get(Book.class, bookID);

        if (book == null) {
            session.getTransaction().rollback();
            session.close();
            throw new RuntimeException("Book not found");
        }

        session.getTransaction().commit();
        return book;
    }


    @Override
    public String deleteBookByAuthorId(Long authorID, Long bookID) {
        session.beginTransaction();
        Author author = session.get(Author.class, authorID);

        if (author == null) {
            session.getTransaction().rollback();
            session.close();
            throw new RuntimeException("Author not found");
        }

        List<Book> books = author.getBooks();

        Book bookToRemove = books.stream()
                .filter(book -> book.getId().equals(bookID))
                .findFirst()
                .orElse(null);

        if (bookToRemove != null) {
            books.remove(bookToRemove);

            bookToRemove.setAuthors(null);

            session.remove(bookToRemove);
            session.getTransaction().commit();
            session.close();

            return "Book deleted successfully";
        } else {
            session.getTransaction().rollback();
            session.close();
            throw new RuntimeException("Book not found for this author");
        }
    }
}
