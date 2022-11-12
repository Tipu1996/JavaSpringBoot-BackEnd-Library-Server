package com.example.javaSpringBoot.books;

import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"book\"")
public class Book {
    @Id
    @GeneratedValue()
    private long id;

    @Column(nullable = false, columnDefinition = "varchar(50)", unique = true)
    private String title;
    @Column(nullable = false, columnDefinition = "varchar(50)")
    private String isbn;
    @Column(nullable = false, columnDefinition = "varchar(1000)")
    private String description;
    @Column(nullable = false, columnDefinition = "varchar(50)")
    private String publisher;
    @Column(nullable = false, columnDefinition = "varchar(25)")
    private String[] authors;
    @Column(nullable = false, columnDefinition = "varchar(25)")
    private String[] categories;
    @Column(nullable = false, columnDefinition = "varchar(10) ")
    private String status = "available", columnDefinition = "String default 'available'";
    @Column(nullable = false)
    private LocalDate publish_date;
    @Column(nullable = true, columnDefinition = "DATE default null")
    private LocalDate borrow_date = null;
    @Column(nullable = true, columnDefinition = "DATE default null")
    private LocalDate return_date = null;

    public Book() {
    }

    public Book(String title, String isbn, String description, String publisher, String[] authors, String[] categories,
            LocalDate publish_date) {
        this.title = title;
        this.isbn = isbn;
        this.description = description;
        this.publisher = publisher;
        this.authors = authors;
        this.categories = categories;
        this.publish_date = publish_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(LocalDate publish_date) {
        this.publish_date = publish_date;
    }

    public LocalDate getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(LocalDate borrow_date) {
        this.borrow_date = borrow_date;
    }

    public LocalDate getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDate return_date) {
        this.return_date = return_date;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", isbn=" + isbn + ", description=" + description
                + ", publisher=" + publisher + ", authors=" + Arrays.toString(authors) + ", categories="
                + Arrays.toString(categories) + ", status=" + status + ", publish_date=" + publish_date
                + ", borrow_date=" + borrow_date + ", return_date=" + return_date + "]";
    }

}

// id serial PRIMARY KEY,
// title varchar(50) not NULL UNIQUE,
// isbn varchar(50) not NULL,
// description varchar(1000) not NULL,
// publisher varchar(50) not NULL,
// authors varchar(25)[] not NULL,
// categories varchar(25)[] not NULL,
// status varchar(10) not NULL default 'available' CHECK(status='available' OR
// status='borrowed'),
// borrower_id int references books(id),
// publish_date date not NULL,
// borrow_date date default NULL,
// return_date date default NULL