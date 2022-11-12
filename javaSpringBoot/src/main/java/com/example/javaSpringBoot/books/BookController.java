package com.example.javaSpringBoot.books;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/book/{bookId}")
    public Optional<Book> getUser(@PathVariable("bookId") long id) {
        return bookService.getBook(id);
    }

    @PostMapping("/addbook")
    public void addBook(@RequestBody Book book) {
        bookService.addNewBook(book);
    }
}
