package com.casadocodigo.basic.livraria.categoria;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Override
    Optional<Categoria> findById( Long id );

    Optional<Categoria> findByNomeIgnoreCase( String nome );
}
