package com.example.mongodbExample.repository;

import com.example.mongodbExample.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {

}