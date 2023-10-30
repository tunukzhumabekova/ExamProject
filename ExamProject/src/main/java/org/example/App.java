package org.example;

import org.example.Enums.Gender;
import org.example.Enums.Genre;
import org.example.config.Config;
import org.example.entity.Author;
import org.example.entity.Book;
import org.example.entity.Publisher;
import org.example.entity.Reader;
import org.example.service.ServiceImpl.AuthorServiceImpl;
import org.example.service.ServiceImpl.BookServiceImpl;
import org.example.service.ServiceImpl.PublisherServiceImpl;
import org.example.service.ServiceImpl.ReaderServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Config.getSession();
        AuthorServiceImpl authorService = new AuthorServiceImpl();
        BookServiceImpl bookService = new BookServiceImpl();
        PublisherServiceImpl publisherService = new PublisherServiceImpl();
        ReaderServiceImpl readerService = new ReaderServiceImpl();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int a = scanner.nextInt();
            switch (a) {
                case 1:
                    System.out.println("save");
                    Author author = new Author("Tunuk", "Zhumabekova", "tunuk@gmailcom", LocalDate.of(2007, 7, 20), "KG", Gender.FEMALE);
                    Reader reader = new Reader("Alina", 20, "alina@gmail.com");
                    Publisher publisher = new Publisher("Publisher 1", "Bishkek");
                    Book book = new Book("Book 1", "KG", LocalDate.of(2020, 1, 5), 2000, Genre.HISTORICAL);


                    List<Author> authors = new ArrayList<>();
                    authors.add(author);
                    List<Publisher> publishers = new ArrayList<>();
                    publishers.add(publisher);
                    List<Book> books = new ArrayList<>();
                    books.add(book);

                    reader.setBooks(books);
                    publisher.setAuthors(authors);
                    publisher.setBooks(books);
                    author.setPublishers(publishers);
                    author.setBooks(books);
                    book.setReader(reader);
                    book.setAuthors(author);
                    book.setPublishers(publisher);

                    readerService.saveReader(reader);
                    authorService.saveAuthor(author);
                    publisherService.savePublisher(publisher);
                    bookService.saveBook(book);
                    break;
                case 2:
                    System.out.println("update author");
                    Author author1 = new Author("Adel", "Zhyldyzbekova", "adel@gmailcom", LocalDate.of(2007, 7, 20), "KG", Gender.FEMALE);
                    System.out.println(authorService.updateAuthor(1L, author1));
                    break;
                case 3:
                    System.out.println("update book");
                    Author author2 = new Author("Ainazik", "Toktomamatova", "ainazik@gmailcom", LocalDate.of(2005, 7, 20), "KG", Gender.FEMALE);
                    System.out.println(bookService.updateBookAuthor(1L, 1L, author2));
                    break;
                case 4:
                    System.out.println("update publisher");
                    Publisher publisher1 = new Publisher("Publisher 2", "Bish");
                    publisherService.updatePublisher(1L, publisher1);
                    break;
                case 5:
                    System.out.println("update reader");
                    Reader reader1 = new Reader("tunuk", 20, "zhumabekova");

                    readerService.updateReader(1L, reader1);
                    break;
                case 6:
                    System.out.println(authorService.getAuthorById(1L));
                    break;
                case 7:
                    System.out.println(authorService.getAuthorsByPublisherId(1L));
                    break;
                case 8:
                    System.out.println(bookService.getBookAndPublisherByBookId(1L));
                    break;
                case 9:
                    System.out.println(publisherService.getPublisherById(1));
                    break;
                case 10:
                    System.out.println(publisherService.getAllPublishers("asc"));
                    break;
                case 11:
                    System.out.println(readerService.getReaderByBookId(1L));
                    break;
                case 12:
                    System.out.println(readerService.getReadersByAuthorId(1L));
                    break;
                case 13:
                    System.out.println(authorService.deleteAuthorById(1L));
                    break;
                case 14:
                    System.out.println(bookService.deleteBookByAuthorId(1L,1L));
                    break;
                case 15:
                    publisherService.deletePublisherById(1L);
                    break;
                case 16:
                    System.out.println(readerService.deleteReaderById(1L));
                    break;
            }
        }
    }
}

