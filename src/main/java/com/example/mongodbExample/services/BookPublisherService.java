package com.example.mongodbExample.services;

import com.example.mongodbExample.model.Book;
import com.example.mongodbExample.model.Publisher;
import com.example.mongodbExample.repository.BookRepository;
import com.example.mongodbExample.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookPublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookRepository bookRepository;

    public Publisher savePublisher (Publisher publisher){
        return publisherRepository.save(publisher);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Publisher> findAllPublishers() {
        return publisherRepository.findAll();
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }


    public Publisher addBookToPublisher(String publisherId, Book book) {
        Book savedBook = bookRepository.save(book);

        Optional<Publisher> optionalPublisher = publisherRepository.findById(publisherId);
        if (optionalPublisher.isPresent()) {
            Publisher publisher = optionalPublisher.get();
            publisher.getBooks().add(savedBook);
            return publisherRepository.save(publisher);
        } else {
            throw new RuntimeException("Publisher not found");
        }
    }



}
