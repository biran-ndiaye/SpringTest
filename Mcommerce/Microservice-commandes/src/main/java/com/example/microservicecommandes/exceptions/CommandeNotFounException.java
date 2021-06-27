package com.example.microservicecommandes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CommandeNotFounException extends RuntimeException{
    public CommandeNotFounException(String message){
        super(message);
    }
}
