package com.example.javaSpringBoot.books;

import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.example.javaSpringBoot.users.User;

@Entity(name = "Book")
@Table(name = "\"book\"")
public class Book {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long id;

    @Column(nullable = false, columnDefinition = "Text")
    private String title;
    @Column(nullable = false, columnDefinition = "Text", unique = true)
    private String isbn;
    @Column(nullable = false, columnDefinition = "Text")
    private String description;
    @Column(nullable = false, columnDefinition = "Text")
    private String publisher;
    @Column(nullable = false, columnDefinition = "Text[]")
    @Type(type = "com.example.javaSpringBoot.PostgreSqlStringArrayType")
    private String[] authors;
    @Column(nullable = false, columnDefinition = "Text[]")
    @Type(type = "com.example.javaSpringBoot.PostgreSqlStringArrayType")
    private String[] categories;
    @Column(nullable = false, columnDefinition = "Text")
    private String status = "available";
    @Column(nullable = false)
    private LocalDate publish_date;
    @Column(nullable = true, columnDefinition = "DATE default null")
    private LocalDate borrow_date = null;
    @Column(nullable = true, columnDefinition = "DATE default null")
    private LocalDate return_date = null;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "borrower_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "user_id_fk"))
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
                + ", borrow_date=" + borrow_date + ", return_date=" + return_date + ", user=" + user + "]";
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