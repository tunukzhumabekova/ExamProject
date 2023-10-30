package org.example.service.ServiceImpl;

import org.example.entity.Author;
import org.example.repository.AuthorRepositoryInterface;
import org.example.repository.repositoryImpl.AuthorRepImpl;
import org.example.service.AuthorServiceInterface;

import java.util.List;

public class AuthorServiceImpl implements AuthorServiceInterface {
    AuthorRepositoryInterface authorRepository=new AuthorRepImpl();

    @Override
    public String saveAuthor(Author author) {
        return authorRepository.saveAuthor(author);
    }

    @Override
    public Author updateAuthor(Long id, Author newAuthor) {
        return authorRepository.updateAuthor(id,newAuthor);
    }

    @Override
    public List<Author> getAuthorById(Long id) {
        return authorRepository.getAuthorById(id);
    }

    @Override
    public List<Author> getAuthorsByPublisherId(Long publisherID) {
        return authorRepository.getAuthorsByPublisherId(publisherID);
    }

    @Override
    public String deleteAuthorById(Long id) {
        return authorRepository.deleteAuthorById(id);
    }
}
