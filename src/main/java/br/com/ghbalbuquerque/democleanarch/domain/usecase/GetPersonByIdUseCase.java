package br.com.ghbalbuquerque.democleanarch.domain.usecase;

import br.com.ghbalbuquerque.democleanarch.application.exception.custom.EntityNotFoundException;
import br.com.ghbalbuquerque.democleanarch.domain.entity.Person;

import java.util.UUID;

public interface GetPersonByIdUseCase {

    Person execute(UUID id) throws EntityNotFoundException;
}
