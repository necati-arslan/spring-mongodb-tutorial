package com.example.mongodbExample.model;


import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Publisher {

    @Id
    private String id;
    private String name;

    @DBRef(lazy = true)
    private List<Book> books = new ArrayList<>();

    public Publisher() {}

    public Publisher(String name, List<Book> books) {
        this.name = name;
        this.books = books != null ? books : new ArrayList<>();
    }
    // Getter ve Setter'lar
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", books=" + books +
                '}';
    }
}
