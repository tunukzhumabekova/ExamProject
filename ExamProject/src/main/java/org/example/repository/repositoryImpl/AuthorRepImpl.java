package org.example.repository.repositoryImpl;

import org.example.config.Config;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.entity.Publisher;
import org.example.repository.AuthorRepositoryInterface;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepImpl implements AuthorRepositoryInterface {
    Session session = Config.getSession().openSession();

    @Override
    public String saveAuthor(Author author) {
        session.getTransaction().begin();
        session.persist(author);
        session.getTransaction().commit();
        session.close();
        return "successfully saved";
    }

    @Override
    public Author updateAuthor(Long id, Author newAuthor) {
        session.beginTransaction();
        session.merge(newAuthor);

        Author author = session.get(Author.class, id);


        if (author != null) {
            author.setLast_name(newAuthor.getLast_name());
            author.setFirst_name(newAuthor.getFirst_name());
            author.setEmail(newAuthor.getEmail());
            author.setDate_of_birth(newAuthor.getDate_of_birth());
            author.setCountry(newAuthor.getCountry());
            session.merge(author);
            session.getTransaction().commit();
            session.close();

            return author;
        } else {
            session.getTransaction().rollback();
            session.close();
            throw new RuntimeException("Author not found");
        }
    }

    @Override
    public List<Author> getAuthorById(Long id) {
        List<Author> authors = new ArrayList<>();
        try (Session session1 = Config.getSession().openSession();) {
            Transaction transaction = session1.beginTransaction();
            Author author = session1.get(Author.class, id);
            authors.add(author);
            System.out.println("Succed");
            transaction.commit();
        }
        return authors;
    }


    @Override
    public List<Author> getAuthorsByPublisherId(Long publisherID) {
        List<Author> authors;
        try (Session session1 = Config.getSession().openSession();) {
            Transaction transaction = session1.beginTransaction();
            Publisher publisher = session1.get(Publisher.class, publisherID);
            authors = new ArrayList<>(publisher.getAuthors());
            System.out.println("Succed");
            transaction.commit();
        }
        return authors;
    }

    @Override
    public String deleteAuthorById(Long id) {
        try(Session session = Config.getSession().openSession()){
            Transaction transaction = session.beginTransaction();
            Author author = session.get(Author.class, id);
            List<Book> books = author.getBooks();
            for (Book b:books) {
                b.setAuthors(null);
            }
            for (Publisher p:
                    author.getPublishers()) {
                p.getAuthors().remove(author);
                session.merge(p);
            }

            author.getBooks().clear();

            session.remove(author);
            transaction.commit();
        }catch (HibernateException e){
            throw new RuntimeException(e.getMessage());
        }
        return "Успешно";
    }
    }

