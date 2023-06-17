package br.com.ghbalbuquerque.democleanarch.application.usecase;

import br.com.ghbalbuquerque.democleanarch.domain.entity.Person;
import br.com.ghbalbuquerque.democleanarch.domain.usecase.GetPersonByIdUseCase;
import br.com.ghbalbuquerque.democleanarch.infrastructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetPersonByIdUseCaseImpl implements GetPersonByIdUseCase {

    @Autowired
    private PersonRepository pessoaRepository;

    @Override
    public Person execute() {
        return null;
    }
}
