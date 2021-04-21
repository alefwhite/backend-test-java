package io.org.alefwhite.domains.repository;

import io.org.alefwhite.domains.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClienteRespository extends JpaRepository<Cliente, Integer> {
    // Finds
    @Query(value = " select * from clientes c where c.nome like '%:nome%' ", nativeQuery = true)
    List<Cliente> findByNome(@Param("nome") String nome );

    @Query(" select c from Cliente c left join fetch c.veiculos where c.id = :id  ")
    Cliente findClienteFetchVeiculos( @Param("id") Integer id );

    @Query(value = " select * from clientes c where c.cpf = :cpf ", nativeQuery = true)
    Optional<Cliente> findCpf(@Param("cpf") String cpf );

    Optional<Cliente> findByCpf(@Param("cpf") String cpf );

    Optional<Cliente> findById(@Param("cpf") Integer id );

    boolean existsByNome(String nome);

    // Deletes
    @Query(" delete from Cliente c where c.nome =:nome ")
    @Modifying
    void deleteByNome(String nome);


}
