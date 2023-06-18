package br.com.ghbalbuquerque.democleanarch.domain.usecase;

import br.com.ghbalbuquerque.democleanarch.application.command.UpdatePersonCommand;
import br.com.ghbalbuquerque.democleanarch.domain.entity.Person;

import java.util.UUID;

public interface UpdatePersonUseCase {

    Person execute(UUID id, UpdatePersonCommand command);
}
