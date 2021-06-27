package com.example.microservicecommandes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class CommandeNotAddeException extends RuntimeException{
    public CommandeNotAddeException(String message){
        super(message);
    }
}
