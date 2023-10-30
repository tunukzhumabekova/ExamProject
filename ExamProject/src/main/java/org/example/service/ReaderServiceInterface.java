package org.example.service;

import org.example.entity.Reader;

public interface ReaderServiceInterface {

    String saveReader(Reader reader);
    Reader updateReader(Long readerId, Reader newReader);
    Reader getReaderByBookId(Long bookId);
    String deleteReaderById(Long readerId);
    Reader getReadersByAuthorId(Long authorId);
}
