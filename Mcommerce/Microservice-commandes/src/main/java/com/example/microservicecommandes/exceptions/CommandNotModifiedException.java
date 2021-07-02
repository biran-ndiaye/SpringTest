package com.example.microservicecommandes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_MODIFIED)
public class CommandNotModifiedException extends RuntimeException{
    public CommandNotModifiedException(String message){
        super(message);
    }
}
