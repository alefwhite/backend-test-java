package io.org.alefwhite.services;

import io.org.alefwhite.domains.entity.Veiculo;
import io.org.alefwhite.rest.dto.request.VeiculoDto;

public interface VeiculoService {
    Veiculo salvar(VeiculoDto dto);
}
