package com.example.javaSpringBoot.books;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getById(long id) {
        return bookRepository.findById(id);
    }

    public void addNewBook(Book book) {
        bookRepository.save(book);
    }

    public void lendBook(long bookId, long userId) throws NameNotFoundException {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (!optionalBook.isPresent())
            throw new NameNotFoundException("Book does not exist");
        optionalBook.get().setStatus("borrowed");
        optionalBook.get().setBorrow_date(LocalDate.now());
        // optionalBook.get().setUser(userId);
    }

    public Optional<Book> getByTitle(String title) {
        return bookRepository.getByTitle(title);
    }

    public Optional<Book> getByIsbn(String isbn) {
        return bookRepository.getByIsbn(isbn);
    }

    public Optional<List<Book>> getByStatus(String status) {
        return bookRepository.getByStatus(status);
    }

    // public Optional<List<Book>> getByAuthor(String author) {
    // return bookRepository.getByAuthor(author);
    // }
}
