package io.org.alefwhite.domains.repository;

import io.org.alefwhite.domains.entity.EntradaSaidaMensalista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensalistaRepository extends JpaRepository<EntradaSaidaMensalista, Integer> {
}
