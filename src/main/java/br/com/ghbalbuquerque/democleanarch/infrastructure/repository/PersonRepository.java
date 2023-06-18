package br.com.ghbalbuquerque.democleanarch.infrastructure.repository;

import br.com.ghbalbuquerque.democleanarch.infrastructure.entity.PersonEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<PersonEntity, UUID> {

    Optional<PersonEntity> findByName(String nome);

    List<PersonEntity> findAllByBirthdate(LocalDate birhdate, Pageable pageable);
}
