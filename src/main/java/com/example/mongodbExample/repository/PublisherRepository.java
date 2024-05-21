package com.example.mongodbExample.repository;

import com.example.mongodbExample.model.Publisher;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PublisherRepository extends MongoRepository<Publisher, String> {
    // Ek sorgular tanımlanabilir
}