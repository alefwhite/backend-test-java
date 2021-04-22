package io.org.alefwhite.rest;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;


public class ApiErrors {
    @Getter
    private List<String> erros;

    public ApiErrors(String messageErro) {
        this.erros = Arrays.asList(messageErro);
    }
}
