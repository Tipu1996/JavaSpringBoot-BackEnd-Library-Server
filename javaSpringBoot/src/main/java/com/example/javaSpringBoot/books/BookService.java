package com.example.javaSpringBoot.books;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javaSpringBoot.users.User;
import com.example.javaSpringBoot.users.UserRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getById(long id) {
        return bookRepository.findById(id);
    }

    public void addNewBook(Book book) {
        bookRepository.save(book);
    }

    public void removeBook(long bookId) throws NameNotFoundException {
        Book book = bookRepository.getReferenceById(bookId);
        if (book == null) {
            throw new NameNotFoundException("Book and/or User does not exist");
        } else {
            // bookRepository.deleteById(bookId);
            bookRepository.delete(book);
        }
    }

    public Optional<Book> getByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public Optional<Book> getByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    public Optional<List<Book>> getByStatus(String status) {
        return bookRepository.findByStatus(status);
    }

    public Optional<List<Book>> getByAuthor(String author) {
        return bookRepository.getByAuthor(author);
    }

    public Optional<List<Book>> getByCategory(String category) {
        return bookRepository.getByCategory(category);
    }

    public void lendBook(long bookId, long userId) throws NameNotFoundException {
        Book book = bookRepository.getReferenceById(bookId);
        User user = userRepository.getReferenceById(userId);
        if (book == null && user == null) {
            throw new NameNotFoundException("Book and/or User does not exist");
        } else {
            if (book != null) {
                book.setStatus("borrowed");
                book.setBorrow_date(LocalDate.now());
                book.setUser(user);
                bookRepository.save(book);
                user.addBook(book);
                userRepository.save(user);
            }
        }
    }

    public void returnBook(long bookId, long userId) throws NameNotFoundException {
        Book book = bookRepository.getReferenceById(bookId);
        User user = userRepository.getReferenceById(userId);
        if (book == null && user == null) {
            throw new NameNotFoundException("Book and/or User does not exist");
        } else {
            if (book != null) {
                book.setStatus("available");
                book.setBorrow_date(null);
                book.setReturn_date(LocalDate.now());
                book.setUser(null);
                bookRepository.save(book);
            }
        }
    }

}
