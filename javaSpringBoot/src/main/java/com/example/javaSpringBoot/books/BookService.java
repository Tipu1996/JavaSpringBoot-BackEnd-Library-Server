package com.example.javaSpringBoot.books;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBook(long id) {
        return bookRepository.findById(id);
    }

    public void addNewBook(Book book) {
        bookRepository.save(book);
    }
}
