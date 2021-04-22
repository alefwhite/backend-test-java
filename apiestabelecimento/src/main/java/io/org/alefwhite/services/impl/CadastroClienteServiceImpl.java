package io.org.alefwhite.services.impl;

import io.org.alefwhite.domains.entity.Cliente;
import io.org.alefwhite.domains.entity.Veiculo;
import io.org.alefwhite.domains.repository.ClienteRespository;
import io.org.alefwhite.domains.repository.VeiculoRepository;
import io.org.alefwhite.exceptions.CadastrarClienteException;
import io.org.alefwhite.rest.dto.CadastroClienteDto;
import io.org.alefwhite.services.CadastroClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CadastroClienteServiceImpl implements CadastroClienteService {
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ClienteRespository clienteRespository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Override
    @Transactional(rollbackOn = CadastrarClienteException.class)
    public Cliente salvar(CadastroClienteDto dto) {
        List<Veiculo> veiculos = new ArrayList<>();

        Cliente cliente = modelMapper.map(dto, Cliente.class);
        Veiculo veiculo = modelMapper.map(dto, Veiculo.class);
        Integer id = clienteRespository.save(cliente).getId();
        veiculo.setCliente(cliente);

        veiculo = veiculoRepository.save(veiculo);

        if(veiculo.getId() == null) {
            throw new CadastrarClienteException("Não foi possível efetuar cadastro");
        }

        veiculos.add(veiculo);
        cliente = clienteRespository.findClienteVeiculos(id);
        cliente.setVeiculos(veiculos);


        return cliente;
    }
}
