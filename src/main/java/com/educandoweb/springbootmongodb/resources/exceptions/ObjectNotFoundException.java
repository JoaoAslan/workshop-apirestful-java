package com.educandoweb.springbootmongodb.resources.exceptions;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String msg) {
        super(msg);
    }
    
    
}
