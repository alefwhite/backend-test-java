package io.org.alefwhite.services.impl;

import io.org.alefwhite.domains.repository.ClienteRespository;
import io.org.alefwhite.domains.repository.VeiculoRepository;
import io.org.alefwhite.services.CadastroClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroClienteServiceImpl implements CadastroClienteService {

    @Autowired
    private ClienteRespository clienteRespository;

    @Autowired
    private VeiculoRepository veiculoRepository;

}
