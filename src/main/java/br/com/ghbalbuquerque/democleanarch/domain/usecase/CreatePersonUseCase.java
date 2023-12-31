package br.com.ghbalbuquerque.democleanarch.domain.usecase;

import br.com.ghbalbuquerque.democleanarch.application.command.CreatePersonCommand;
import br.com.ghbalbuquerque.democleanarch.application.exception.custom.CreateEntityException;
import br.com.ghbalbuquerque.democleanarch.domain.entity.Person;

public interface CreatePersonUseCase {

    Person execute(CreatePersonCommand command) throws CreateEntityException;
}
