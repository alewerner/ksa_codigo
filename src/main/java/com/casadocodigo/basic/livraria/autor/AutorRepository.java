package com.casadocodigo.basic.livraria.autor;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Override
    Optional<Autor> findById(Long aLong);

    List<Autor> findByEmail(String email);

    Optional<Autor> findByNome(String nome);

}
