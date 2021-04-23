package io.org.alefwhite.services.impl;

import io.org.alefwhite.domains.entity.Cliente;
import io.org.alefwhite.domains.entity.Veiculo;
import io.org.alefwhite.domains.enums.TipoVeiculo;
import io.org.alefwhite.domains.repository.ClienteRespository;
import io.org.alefwhite.domains.repository.VeiculoRepository;
import io.org.alefwhite.exceptions.CadastrarClienteException;
import io.org.alefwhite.rest.dto.CadastroClienteDto;
import io.org.alefwhite.services.CadastroClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CadastroClienteServiceImpl implements CadastroClienteService {
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ClienteRespository clienteRespository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Override
    @Transactional(rollbackOn = CadastrarClienteException.class)
    public Cliente salvar(CadastroClienteDto clienteDto) {
        Cliente cliente = modelMapper.map(clienteDto, Cliente.class);
        List<Veiculo> veiculoCliente = cliente.getVeiculos();

        try {

            Veiculo veiculo = new Veiculo(
                    veiculoCliente.get(0).getModelo(),
                    veiculoCliente.get(0).getMarca(),
                    veiculoCliente.get(0).getCor(),
                    veiculoCliente.get(0).getPlaca(),
                    TipoVeiculo.valueOf(veiculoCliente.get(0).getTipoVeiculo().name())
            );

            clienteRespository.save(cliente);

            veiculo.setCliente(cliente);
            veiculo = veiculoRepository.save(veiculo);

            if(veiculo.getId() == null) {
                throw new CadastrarClienteException("Não foi possível efetuar cadastro");
            }

            veiculoCliente.set(0, veiculo);

            cliente.setVeiculos(veiculoCliente);

            return cliente;

        } catch (Exception e) {
            throw new CadastrarClienteException("Não foi possível efetuar cadastro! Existem dados inválidos");
        }

    }
}
