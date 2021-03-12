package com.casadocodigo.basic.livraria.autor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {

    @Override
    Optional<Autor> findById(Long aLong);

    Optional<Autor> findByEmail(String email);
}
