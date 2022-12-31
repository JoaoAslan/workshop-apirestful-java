package com.educandoweb.springbootmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.educandoweb.springbootmongodb.domain.User;

public interface UserRepository extends MongoRepository<User, String> {
    
}
