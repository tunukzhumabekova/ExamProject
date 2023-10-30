package org.example.service;

import org.example.entity.Publisher;

import java.util.List;

public interface PublisherServiceInterface {
    Publisher savePublisher(Publisher publisher);
    Publisher getPublisherById(int id);
    List<Publisher> getAllPublishers( String ascDesc);
    Publisher updatePublisher(Long id,Publisher publisher);
    void deletePublisherById(long id);
}
