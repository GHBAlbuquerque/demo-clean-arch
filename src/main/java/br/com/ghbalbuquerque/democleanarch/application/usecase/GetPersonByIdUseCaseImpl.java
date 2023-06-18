package br.com.ghbalbuquerque.democleanarch.application.usecase;

import br.com.ghbalbuquerque.democleanarch.domain.entity.Person;
import br.com.ghbalbuquerque.democleanarch.domain.usecase.GetPersonByIdUseCase;
import br.com.ghbalbuquerque.democleanarch.infrastructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetPersonByIdUseCaseImpl implements GetPersonByIdUseCase {

    //TODO: impl

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person execute(UUID id) {
        return null;
    }
}
