package br.com.ghbalbuquerque.democleanarch.application.usecase;

import br.com.ghbalbuquerque.democleanarch.domain.entity.Person;
import br.com.ghbalbuquerque.democleanarch.domain.usecase.ListAllPersonsUseCase;
import br.com.ghbalbuquerque.democleanarch.infrastructure.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllPersonsUseCaseImpl implements ListAllPersonsUseCase {

    @Autowired
    private PersonRepository pessoaRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<Person> execute() {
        return null;
    }
}
