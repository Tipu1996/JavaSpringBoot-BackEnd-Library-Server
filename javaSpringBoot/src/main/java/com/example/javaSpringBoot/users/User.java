package com.example.javaSpringBoot.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue()
    private long id;

    @Column(nullable = false, length = 50)
    private String first_name;
    @Column(nullable = false, length = 50)
    private String last_name;
    @Column(nullable = false, length = 50, unique = true)
    private String email;
    @Column(length = 255)
    private String password;
    @Column(nullable = false, length = 255, columnDefinition = "varchar(255) default '/'")
    private String picture = "/";
    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean is_admin = false;
    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean is_verified = false;
    @Column(length = 6)
    private String code;

    public User() {
    }

    public User(String first_name, String last_name, String email, String picture,
            Boolean is_admin, Boolean is_verified) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.picture = picture;
        this.is_admin = is_admin;
        this.is_verified = is_verified;
    }

    public User(String first_name, String last_name, String email, String password, String code) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Boolean getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(Boolean is_admin) {
        this.is_admin = is_admin;
    }

    public Boolean getIs_verified() {
        return is_verified;
    }

    public void setIs_verified(Boolean is_verified) {
        this.is_verified = is_verified;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
                + ", password=" + password + ", picture=" + picture + ", is_admin=" + is_admin + ", is_verified="
                + is_verified + ", code=" + code + "]";
    }

}

// id serial PRIMARY KEY,
// first_name varchar(50) not NULL,
// last_name varchar(50) not NULL,
// email varchar(50) not NULL UNIQUE,
// password varchar(255) CHECK (length(password)>=5) DEFAULT null,
// picture varchar(255) NOT NULL default '/',
// is_admin Boolean NOT NULL DEFAULT false,
// is_verified Boolean NOT NULL DEFAULT false,
// code varchar(8) DEFAULT NULL