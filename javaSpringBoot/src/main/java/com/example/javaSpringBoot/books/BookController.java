package com.example.javaSpringBoot.books;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/book/id/{bookId}")
    public Optional<Book> getById(@PathVariable("bookId") long id) {
        return bookService.getById(id);
    }

    @GetMapping("/book/title/{title}")
    public Optional<Book> getByTitle(@PathVariable("title") String title) {
        return bookService.getByTitle(title);
    }

    @GetMapping("/book/isbn/{isbn}")
    public Optional<Book> getByIsbn(@PathVariable("isbn") String isbn) {
        return bookService.getByIsbn(isbn);
    }

    @GetMapping("/book/status/{status}")
    public Optional<List<Book>> getByStatus(@PathVariable("status") String status) {
        return bookService.getByStatus(status);
    }

    // @GetMapping("/book/author/{author}")
    // public Optional<List<Book>> getUser(@PathVariable("author") String author) {
    // return bookService.getByAuthor(author);
    // }

    // @GetMapping("/book/title/{title}")
    // public Optional<Book> getUser(@PathVariable("title") String title) {
    // return bookService.getByTitle(title);
    // }

    @PostMapping("/addbook")
    public void addBook(@RequestBody Book book) {
        bookService.addNewBook(book);
    }

    @PutMapping("/lend/{bookId}/user/{userId}")
    public void lendBook(@PathVariable("bookId") long bookId, @PathVariable("userId") long userId)
            throws NameNotFoundException {
        bookService.lendBook(bookId, userId);
    }
}
