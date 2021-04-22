package io.org.alefwhite.rest.controllers;

import io.org.alefwhite.domains.entity.Cliente;
import io.org.alefwhite.domains.entity.Veiculo;
import io.org.alefwhite.domains.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo save (@RequestBody Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    @GetMapping
    public List<Veiculo> getVeiculos (Veiculo filtro) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher( ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);

        return veiculoRepository.findAll(example);
    }

    @GetMapping("/{id}")
    public Veiculo getVeiculoById ( @PathVariable Integer id ) {
        return veiculoRepository
                .findById(id)
                .orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.NOT_FOUND, "Veiculo não encontrado")
                );
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id, @RequestBody Veiculo veiculo) {
        veiculoRepository.findById(id)
                .map(v -> {
                    veiculoRepository.deleteById(v.getId());
                    return Void.TYPE;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veiculo não encontrado"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Veiculo veiculo) {
        veiculoRepository.findById(id)
        .map(v -> {
            veiculo.setId(v.getId());
            veiculoRepository.save(veiculo);
            return veiculo;
        })
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veiculo não encontrado"));
    }

}
