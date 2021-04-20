package io.org.alefwhite.domains.repository;

import io.org.alefwhite.domains.entity.Taxa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxaRepository extends JpaRepository<Taxa, Integer> {
}
