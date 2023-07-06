package com.domain;

import java.util.UUID;

public class Book {
    private UUID id;
    private String title;
    private String author;

    public Book() {
    }

    public Book(String title, String author) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.author = author;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String athor) {
        this.author = athor;
    }

}
