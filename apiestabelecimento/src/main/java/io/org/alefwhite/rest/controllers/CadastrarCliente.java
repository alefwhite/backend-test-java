package io.org.alefwhite.rest.controllers;

import io.org.alefwhite.domains.entity.Cliente;
import io.org.alefwhite.rest.dto.CadastroClienteDto;
import io.org.alefwhite.services.CadastroClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/clientes/cadastrar")
public class CadastrarCliente {

    @Autowired
    private CadastroClienteService cadastroClienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody @Valid CadastroClienteDto dto) {
        return cadastroClienteService.salvar(dto);
    }
}
