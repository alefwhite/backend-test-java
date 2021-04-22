package io.org.alefwhite.rest.controllers;

import io.org.alefwhite.exceptions.CadastrarClienteException;
import io.org.alefwhite.exceptions.VeiculoException;
import io.org.alefwhite.rest.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(CadastrarClienteException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleCadastrarClienteException(CadastrarClienteException exception) {
        String errorMessage = exception.getMessage();
        return new ApiErrors(errorMessage);
    }

    @ExceptionHandler(VeiculoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleVeiculoException(VeiculoException exception) {
        String errorMessage = exception.getMessage();
        return new ApiErrors(errorMessage);
    }

}
