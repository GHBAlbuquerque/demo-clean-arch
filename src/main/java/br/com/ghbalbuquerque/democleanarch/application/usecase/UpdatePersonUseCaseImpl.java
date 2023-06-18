package br.com.ghbalbuquerque.democleanarch.application.usecase;

import br.com.ghbalbuquerque.democleanarch.application.command.UpdatePersonCommand;
import br.com.ghbalbuquerque.democleanarch.domain.entity.Person;
import br.com.ghbalbuquerque.democleanarch.domain.usecase.UpdatePersonUseCase;
import br.com.ghbalbuquerque.democleanarch.infrastructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdatePersonUseCaseImpl implements UpdatePersonUseCase {

    //TODO: impl

    @Autowired
    private PersonRepository repository;

    @Override
    public Person execute(UUID id, UpdatePersonCommand command) {
        return null;
    }
}
