package org.example.service.ServiceImpl;

import org.example.entity.Publisher;
import org.example.repository.PublisherRepositoryInterface;
import org.example.repository.repositoryImpl.PublisherRepImpl;
import org.example.service.PublisherServiceInterface;

import java.util.List;

public class PublisherServiceImpl implements PublisherServiceInterface {
    PublisherRepositoryInterface publisherRepository=new PublisherRepImpl();
    @Override
    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.savePublisher(publisher);
    }

    @Override
    public Publisher getPublisherById(int id) {
        return publisherRepository.getPublisherById(id);
    }

    @Override
    public List<Publisher> getAllPublishers( String ascDesc) {
        return publisherRepository.getAllPublishers(ascDesc);
    }

    @Override
    public Publisher updatePublisher(Long id ,Publisher publisher) {
        return publisherRepository.updatePublisher(id,publisher);
    }

    @Override
    public void deletePublisherById(long id) {
publisherRepository.deletePublisherById(id);
    }
}
