package com.example.javaSpringBoot.books;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Long> {

    // @Query("Select b FROM Book b WHERE b.title=?1")
    Optional<Book> findByTitle(String Title);

    // @Query("Select b FROM Book b WHERE b.isbn=?1")
    Optional<Book> findByIsbn(String isbn);

    @Query("Select b FROM Book b WHERE b.status=?1")
    Optional<List<Book>> findByStatus(String status);

    // you have to use the @Table name in native queries while in JPQL you have to
    // use @Entity names
    @Query(value = "SELECT *, array_to_string(authors, ' ') FROM book WHERE array_to_string(authors, ' ') LIKE %?1%", nativeQuery = true)
    Optional<List<Book>> getByAuthor(String author);

    @Query(value = "SELECT *, array_to_string(categories, ' ') FROM book WHERE array_to_string(categories, ' ') LIKE %:category%", nativeQuery = true)
    Optional<List<Book>> getByCategory(@Param("category") String category);
}
