package io.org.alefwhite.rest.controllers;

import io.org.alefwhite.domains.entity.Cliente;
import io.org.alefwhite.domains.entity.Empresa;
import io.org.alefwhite.rest.dto.EmpresaDTO;
import io.org.alefwhite.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Empresa save (@RequestBody @Valid EmpresaDTO empresaDTO) {
        return empresaService.salvar(empresaDTO);
    }
}
