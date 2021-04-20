package io.org.alefwhite.domains.repository;

import io.org.alefwhite.domains.entity.EntradaSaidaAvulso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvulsoRepository extends JpaRepository<EntradaSaidaAvulso, Integer> {
}
