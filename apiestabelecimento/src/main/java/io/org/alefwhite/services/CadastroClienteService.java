package io.org.alefwhite.services;

import io.org.alefwhite.domains.entity.Cliente;
import io.org.alefwhite.rest.dto.CadastroClienteDto;

public interface CadastroClienteService {
    Cliente salvar(CadastroClienteDto dto);
}
