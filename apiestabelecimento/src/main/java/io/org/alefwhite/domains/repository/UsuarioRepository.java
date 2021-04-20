package io.org.alefwhite.domains.repository;

import io.org.alefwhite.domains.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
