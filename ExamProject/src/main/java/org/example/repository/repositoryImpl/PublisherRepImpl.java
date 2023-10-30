package org.example.repository.repositoryImpl;

import jakarta.persistence.TypedQuery;
import org.example.config.Config;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.entity.Publisher;
import org.example.repository.PublisherRepositoryInterface;
import org.hibernate.Session;

import java.util.List;

public class PublisherRepImpl implements PublisherRepositoryInterface {
    Session session = Config.getSession().openSession();

    @Override
    public Publisher savePublisher(Publisher publisher) {
        session.getTransaction().begin();
        session.merge(publisher);
        session.getTransaction().commit();
        session.close();
        return publisher;

    }

    @Override
    public Publisher getPublisherById(int id) {
        session.beginTransaction();
        Publisher publisher = session.get(Publisher.class, id);
        session.getTransaction().commit();
        session.close();
        return publisher;
    }


    @Override
    public List<Publisher> getAllPublishers(String ascDesc) {
        session.beginTransaction();
        String jpqlQuery = "SELECT p FROM Publisher p";

        if (ascDesc != null && ascDesc.equalsIgnoreCase("asc")) {
            jpqlQuery += " ORDER BY p.name ASC";
        } else if (ascDesc != null && ascDesc.equalsIgnoreCase("desc")) {
            jpqlQuery += " ORDER BY p.name DESC";
        }

        TypedQuery<Publisher> query = session.createQuery(jpqlQuery, Publisher.class);
        List<Publisher> publishers = query.getResultList();

        session.getTransaction().commit();


        return publishers;
    }

    @Override
    public Publisher updatePublisher(Long id, Publisher publisher) {
        session.getTransaction().begin();
        session.merge(publisher);
        Publisher publisher1 = session.get(Publisher.class, id);

        if (publisher != null) {
            publisher1.setName(publisher.getName());
            publisher1.setAddress(publisher.getAddress());
            session.getTransaction().commit();
            session.close();
            return publisher;
        } else {
            session.getTransaction().rollback();
            session.close();
            throw new RuntimeException("Publisher not found");
        }
    }

    @Override
    public void deletePublisherById(long id) {
        session.beginTransaction();
        Publisher publisher = session.get(Publisher.class, id);

        for (Author author : publisher.getAuthors()) {
            author.getPublishers().remove(publisher);
        }
        publisher.getAuthors().clear();

        for (Book book : publisher.getBooks()) {
            book.setPublishers(null);

        }
        publisher.getBooks().clear();

        session.remove(publisher);
        session.getTransaction().commit();
        session.close();

    }

}
