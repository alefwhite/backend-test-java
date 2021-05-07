package io.org.alefwhite.services.impl;

import io.org.alefwhite.domains.entity.Cliente;
import io.org.alefwhite.domains.entity.Veiculo;
import io.org.alefwhite.domains.enums.TipoVeiculo;
import io.org.alefwhite.domains.repository.ClienteRespository;
import io.org.alefwhite.domains.repository.VeiculoRepository;
import io.org.alefwhite.exceptions.VeiculoException;
import io.org.alefwhite.rest.dto.request.VeiculoDto;
import io.org.alefwhite.services.VeiculoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class VeiculoServiceImpl implements VeiculoService {
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ClienteRespository clienteRespository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Override
    @Transactional
    public Veiculo salvar(VeiculoDto dto) {
        Veiculo veiculo = modelMapper.map(dto, Veiculo.class);

        Optional<Cliente> cliente = clienteRespository.findById(dto.getIdCliente());

        if(!cliente.isPresent()) {
            throw new VeiculoException("Não possível cadastar veículo");
        }
        veiculo.setTipoVeiculo(TipoVeiculo.valueOf(dto.getTipoVeiculo().name()));
        veiculo.setCliente(cliente.get());

        return veiculoRepository.save(veiculo);
    }
}
