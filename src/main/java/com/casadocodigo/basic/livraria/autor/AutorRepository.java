package com.casadocodigo.basic.livraria.autor;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Override
    Optional<Autor> findById( Long id );

    List<Autor> findByEmail( String email );

    Optional<Autor> findByNomeIgnoreCase( String nome );

}