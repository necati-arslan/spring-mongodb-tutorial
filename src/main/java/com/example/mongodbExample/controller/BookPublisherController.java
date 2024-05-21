package com.example.mongodbExample.controller;

import com.example.mongodbExample.model.Book;
import com.example.mongodbExample.model.Publisher;
import com.example.mongodbExample.services.BookPublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Queue;

@RestController
@RequestMapping("/api")
public class BookPublisherController {

    @Autowired
    private BookPublisherService bookPublisherService;

    @PostMapping("/publishers")
    public Publisher createPublisher(@RequestBody Publisher publisher) {
        return bookPublisherService.savePublisher(publisher);
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return bookPublisherService.saveBook(book);
    }

    @GetMapping("/publishers")
    public List<Publisher> getAllPublishers() {
        return bookPublisherService.findAllPublishers();
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookPublisherService.findAllBooks();
    }

    @PostMapping("/publishers/{publisherId}/books")
    public Publisher addBookToPublisher(@PathVariable String publisherId, @RequestBody Book book) {
        return bookPublisherService.addBookToPublisher(publisherId, book);
    }


}
