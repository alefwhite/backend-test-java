package io.org.alefwhite.rest.controllers;

import io.org.alefwhite.services.CadastroClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cadastrar")
public class CadastroCliente {

    @Autowired
    private CadastroClienteService cadastroClienteService;
}
