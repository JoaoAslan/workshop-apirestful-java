package com.educandoweb.springbootmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.educandoweb.springbootmongodb.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
