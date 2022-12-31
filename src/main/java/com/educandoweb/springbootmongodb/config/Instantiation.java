package com.educandoweb.springbootmongodb.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.educandoweb.springbootmongodb.domain.Post;
import com.educandoweb.springbootmongodb.domain.User;
import com.educandoweb.springbootmongodb.dto.AuthorDTO;
import com.educandoweb.springbootmongodb.repositories.PostRepository;
import com.educandoweb.springbootmongodb.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User u1 = new User(null, "Maria Brown", "maria@gmail.com");
        User u2 = new User(null, "Alex Green", "alex@gmail.com");
        User u3 = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));
        
        Post p1 = new Post(null, Instant.now(),  "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(u1));
        Post p2 = new Post(null, Instant.now(), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(u1));

        postRepository.saveAll(Arrays.asList(p1, p2));
    }
}
