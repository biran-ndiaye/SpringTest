package com.example.clientui.exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String invoqueur, Response response) {

        if(response.status() == 404){
            return new ProductNotExistException("Produit non trouvé");
        }

        return defaultErrorDecoder.decode(invoqueur, response);
    }
}
