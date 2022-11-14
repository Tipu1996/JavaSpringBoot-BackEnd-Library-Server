package com.example.javaSpringBoot.books;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("Select b FROM Book b WHERE b.title=?1")
    Optional<Book> getByTitle(String Title);

    @Query("Select b FROM Book b WHERE b.isbn=?1")
    Optional<Book> getByIsbn(String isbn);

    @Query("Select b FROM Book b WHERE b.status=?1")
    Optional<List<Book>> getByStatus(String status);

    @Query(value = "SELECT *, array_to_string(authors, ' ') FROM Book WHERE array_to_string(authors, ' ') LIKE %?1%", nativeQuery = true)
    Optional<List<Book>> getByAuthor(String author);

    @Query(value = "SELECT *, array_to_string(categories, ' ') FROM Book WHERE array_to_string(categories, ' ') LIKE %?1%", nativeQuery = true)
    Optional<List<Book>> getByCategory(String category);
}
