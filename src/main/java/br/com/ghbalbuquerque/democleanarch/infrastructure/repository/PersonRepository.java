package br.com.ghbalbuquerque.democleanarch.infrastructure.repository;

import br.com.ghbalbuquerque.democleanarch.infrastructure.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, UUID> {

    Optional<PersonRepository> findByName(String nome);
}
