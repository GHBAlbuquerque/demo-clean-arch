package br.com.ghbalbuquerque.democleanarch.application.usecase;

import br.com.ghbalbuquerque.democleanarch.domain.entity.Person;
import br.com.ghbalbuquerque.democleanarch.domain.usecase.ListAllPersonsUseCase;
import br.com.ghbalbuquerque.democleanarch.infrastructure.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListAllPersonsUseCaseImpl implements ListAllPersonsUseCase {

    //TODO: impl

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Page<Person> execute(Pageable pageable) {
        final var result = personRepository.findAll(pageable);
        final var response = result.map(
                personEntity -> mapper.map(personEntity, Person.class)
        );

        return response;
    }
}
