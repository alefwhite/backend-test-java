package io.org.alefwhite.services;

import io.org.alefwhite.domains.entity.Empresa;
import io.org.alefwhite.rest.dto.request.EmpresaDTO;

public interface EmpresaService {

    Empresa salvar(EmpresaDTO empresaDTO);
}
