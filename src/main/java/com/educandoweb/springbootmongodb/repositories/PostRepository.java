package com.educandoweb.springbootmongodb.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.educandoweb.springbootmongodb.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

    // https://docs.spring.io/spring-data/data-document/docs/current/reference/html/
    // https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#preface
    List<Post> findByTitleContainingIgnoreCase(String text);
}
