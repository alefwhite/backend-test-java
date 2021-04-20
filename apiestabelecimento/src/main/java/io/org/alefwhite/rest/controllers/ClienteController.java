package io.org.alefwhite.rest.controllers;

import io.org.alefwhite.domains.entity.Cliente;
import io.org.alefwhite.domains.repository.ClienteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
(
    value = "/api/clientes",
    produces = { "application/json", "application/xml" }
)

public class ClienteController {

    @Autowired
    private ClienteRespository clienteRespository;

    @GetMapping
    public ResponseEntity getClientes () {
        List<Cliente> clientes = clienteRespository.findAll();

        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity getClienteByCpf ( @PathVariable String cpf ) {
        Optional<Cliente> cliente = clienteRespository.findCpf(cpf);

        if(cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }

        return ResponseEntity.notFound().build();
    }
}
