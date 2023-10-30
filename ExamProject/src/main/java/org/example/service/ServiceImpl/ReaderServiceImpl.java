package org.example.service.ServiceImpl;

import org.example.entity.Reader;
import org.example.repository.ReaderRepositoryInterface;
import org.example.repository.repositoryImpl.ReaderRepImpl;
import org.example.service.ReaderServiceInterface;

public class ReaderServiceImpl implements ReaderServiceInterface {
    ReaderRepositoryInterface readerRepository=new ReaderRepImpl();
    @Override
    public String saveReader(Reader reader) {
        return readerRepository.saveReader(reader);
    }

    @Override
    public Reader updateReader(Long readerId, Reader newReader) {
        return readerRepository.updateReader(readerId,newReader);
    }

    @Override
    public Reader getReaderByBookId(Long bookId) {
        return readerRepository.getReaderByBookId(bookId);
    }

    @Override
    public String deleteReaderById(Long readerId) {
        return readerRepository.deleteReaderById(readerId);
    }

    @Override
    public Reader getReadersByAuthorId(Long authorId) {
        return readerRepository.getReadersByAuthorId(authorId);
    }
}
