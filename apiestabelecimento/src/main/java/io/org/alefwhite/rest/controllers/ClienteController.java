package io.org.alefwhite.rest.controllers;

import io.org.alefwhite.domains.entity.Cliente;
import io.org.alefwhite.domains.repository.ClienteRespository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping
(
    value = "/api/clientes",
    produces = { "application/json", "application/xml" }
)

public class ClienteController {

    private ClienteRespository clienteRespository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save (@RequestBody @Valid Cliente cliente) {
        return clienteRespository.save(cliente);
    }

    @GetMapping
    public List<Cliente> getClientes (Cliente filtro) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher( ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);

        return clienteRespository.findAll(example);
    }

    @GetMapping("/{id}")
    public Cliente getClienteById ( @PathVariable Integer id ) {
        return clienteRespository
                .findById(id)
                .orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente não encontrado")
                );
    }


    @GetMapping("/cpf")
    public ResponseEntity getClienteByCpf ( @RequestParam(required = false) String cpf ) {
        Optional<Cliente> cliente = clienteRespository.findCpf(cpf);

        if(cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }

        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete ( @PathVariable Integer id ) {
        Optional<Cliente> cliente = clienteRespository.findById(id);

        if(!cliente.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
        }

        clienteRespository.delete(cliente.get());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update ( @PathVariable Integer id, @RequestBody Cliente cliente ) {
         clienteRespository.findById(id)
            .map(existsCliente -> {
                cliente.setId(existsCliente.getId());
                clienteRespository.save(cliente);
                return existsCliente;
            })
             .orElseThrow(() ->
                     new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado")
             );
    }



}
