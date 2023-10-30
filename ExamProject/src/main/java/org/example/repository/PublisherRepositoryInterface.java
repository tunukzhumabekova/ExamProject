package org.example.repository;


import org.example.entity.Publisher;

import java.util.List;

public interface PublisherRepositoryInterface {
    Publisher savePublisher(Publisher publisher);
    Publisher getPublisherById(int id);
    List<Publisher> getAllPublishers(String ascDesc);
    Publisher updatePublisher(Long id,Publisher publisher);
    void deletePublisherById(long id);
}
