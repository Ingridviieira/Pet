//Arrumando as mensangens do sistema HTTP 

package br.com.fiap.PetMania.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RestNotFoundException extends RuntimeException {

    public RestNotFoundException(String message) {
        super(message);
    }

}