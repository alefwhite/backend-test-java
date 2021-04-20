package io.org.alefwhite.domains.repository;

import io.org.alefwhite.domains.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
}
