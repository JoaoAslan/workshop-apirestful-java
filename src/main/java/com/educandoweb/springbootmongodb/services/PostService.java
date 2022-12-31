package com.educandoweb.springbootmongodb.services;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.springbootmongodb.domain.Post;
import com.educandoweb.springbootmongodb.repositories.PostRepository;
import com.educandoweb.springbootmongodb.resources.exceptions.ObjectNotFoundException;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByTitle(String text) {
        return repository.findByTitle(text);
    }

    public List<Post> fullSearch(String text, LocalDate minDate, LocalDate maxDate) {
        try {
            maxDate = LocalDate.of(maxDate.getYear(), maxDate.getMonthValue(), maxDate.getDayOfMonth() + 1);
            return repository.fullSearch(text, minDate, maxDate);
        }
        catch (DateTimeException e) {
            return repository.fullSearch(text, minDate, maxDate);
        }
    }
}
