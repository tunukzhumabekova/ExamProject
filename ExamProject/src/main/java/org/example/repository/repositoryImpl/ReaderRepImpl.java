package org.example.repository.repositoryImpl;

import org.example.config.Config;
import org.example.entity.Book;
import org.example.entity.Reader;
import org.example.repository.ReaderRepositoryInterface;
import org.hibernate.Session;

public class ReaderRepImpl implements ReaderRepositoryInterface {
    Session session = Config.getSession().openSession();

    @Override
    public String saveReader(Reader reader) {
        session.getTransaction().begin();
        session.persist(reader);
        session.getTransaction().commit();
        session.close();
        return null;
    }

    @Override
    public Reader updateReader(Long readerId, Reader newReader) {
        session.beginTransaction();
        Reader reader = session.get(Reader.class, readerId);
        reader.setEmail(newReader.getEmail());
        reader.setAge(newReader.getAge());
        reader.setName(newReader.getName());
        session.merge(reader);
        session.getTransaction().commit();
        session.close();
        return reader;
    }


    @Override
    public Reader getReaderByBookId(Long bookId) {
        session.beginTransaction();

        Book book = session.get(Book.class, bookId);



        Reader reader = book.getReader();

        session.getTransaction().commit();

        return reader;

    }

    @Override
    public String deleteReaderById(Long readerId) {
        session.getTransaction().begin();

        Reader reader = session.get(Reader.class, readerId);
        for (Book book : reader.getBooks()) {
            book.setReader(null);
        }
        reader.getBooks().clear();
        session.remove(reader);
        session.getTransaction().commit();
        session.close();
        return "deleted";
    }


    @Override
    public Reader getReadersByAuthorId(Long authorId) {
        return null;
    }
}
