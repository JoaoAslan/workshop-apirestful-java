package com.educandoweb.springbootmongodb.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.educandoweb.springbootmongodb.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

    // https://docs.spring.io/spring-data/data-document/docs/current/reference/html/
    // https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#preface
    List<Post> findByTitleContainingIgnoreCase(String text);

    // https://www.mongodb.com/docs/manual/reference/operator/query/regex/
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> findByTitle(String text);

    @Query("{ $and: [ { date: { $gte: ?1 } }, { date: { $lte: ?2 } } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate);
}
