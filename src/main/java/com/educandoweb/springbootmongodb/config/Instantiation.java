package com.educandoweb.springbootmongodb.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.educandoweb.springbootmongodb.domain.Post;
import com.educandoweb.springbootmongodb.domain.User;
import com.educandoweb.springbootmongodb.dto.AuthorDTO;
import com.educandoweb.springbootmongodb.dto.CommentDTO;
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

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        userRepository.deleteAll();
        postRepository.deleteAll();

        User u1 = new User(null, "Maria Brown", "maria@gmail.com");
        User u2 = new User(null, "Alex Green", "alex@gmail.com");
        User u3 = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));
        
        Post p1 = new Post(null, LocalDate.parse("21/03/2023", dtf) ,  "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(u1));
        Post p2 = new Post(null, LocalDate.parse("23/03/2023", dtf), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(u1));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", LocalDate.parse("21/03/2023", dtf), new AuthorDTO(u2));
        CommentDTO c2 = new CommentDTO("Aproveite!", LocalDate.parse("22/03/2023", dtf), new AuthorDTO(u3));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", LocalDate.parse("23/03/2023", dtf), new AuthorDTO(u2));
        
        p1.getComments().addAll(Arrays.asList(c1, c2));
        p2.getComments().add(c3);

        postRepository.saveAll(Arrays.asList(p1, p2));

        u1.getPosts().addAll(Arrays.asList(p1, p2));
        userRepository.save(u1);
    }
}
