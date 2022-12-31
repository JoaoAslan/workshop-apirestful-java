package com.educandoweb.springbootmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.springbootmongodb.domain.User;
import com.educandoweb.springbootmongodb.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    
    public List<User> findAll() {
        return repository.findAll();   
    }

}
