package org.example.repository;


import org.example.entity.Reader;

public interface ReaderRepositoryInterface {
    String saveReader(Reader reader);
    Reader updateReader(Long readerId, Reader newReader);
    Reader getReaderByBookId(Long bookId);
    String deleteReaderById(Long readerId);
    Reader getReadersByAuthorId(Long authorId);
}
