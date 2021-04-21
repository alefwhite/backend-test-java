package io.org.alefwhite.rest.controllers;

import io.org.alefwhite.domains.entity.Cliente;
import io.org.alefwhite.domains.repository.ClienteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/cpf")
    public ResponseEntity getClienteByCpf ( @RequestParam(required = false) String cpf ) {
        Optional<Cliente> cliente = clienteRespository.findCpf(cpf);

        if(cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getClienteById ( @PathVariable Integer id ) {
        Optional<Cliente> cliente = clienteRespository.findById(id);

        if(cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity delete ( @PathVariable Integer id ) {
        Optional<Cliente> cliente = clienteRespository.findById(id);

        if(cliente.isPresent()) {
            clienteRespository.delete( cliente.get() );
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity update ( @PathVariable Integer id, @RequestBody Cliente cliente ) {
        return clienteRespository.findById(id)
                .map(existsCliente -> {
                    cliente.setId(existsCliente.getId());
                    clienteRespository.save(cliente);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity save (@RequestBody Cliente cliente) {
        Cliente clienteSave = clienteRespository.save(cliente);
        return ResponseEntity.ok(clienteSave);
    }
}
