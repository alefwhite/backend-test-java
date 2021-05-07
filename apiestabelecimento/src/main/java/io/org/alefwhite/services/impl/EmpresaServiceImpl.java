package io.org.alefwhite.services.impl;

import io.org.alefwhite.domains.entity.Empresa;
import io.org.alefwhite.domains.repository.EmpresaRepository;
import io.org.alefwhite.rest.dto.request.EmpresaDTO;
import io.org.alefwhite.services.EmpresaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmpresaServiceImpl implements EmpresaService {
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    @Transactional
    public Empresa salvar(EmpresaDTO empresaDTO) {
        Empresa empresa = modelMapper.map(empresaDTO, Empresa.class);

        return empresaRepository.save(empresa);
    }
}
