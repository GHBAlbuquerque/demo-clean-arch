package br.com.ghbalbuquerque.democleanarch.application.usecase;

import br.com.ghbalbuquerque.democleanarch.application.exception.CustomExceptionEnum;
import br.com.ghbalbuquerque.democleanarch.application.exception.custom.EntityNotFoundException;
import br.com.ghbalbuquerque.democleanarch.domain.entity.Person;
import br.com.ghbalbuquerque.democleanarch.domain.usecase.GetPersonByIdUseCase;
import br.com.ghbalbuquerque.democleanarch.infrastructure.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetPersonByIdUseCaseImpl implements GetPersonByIdUseCase {

    //TODO: impl

    @Autowired
    private PersonRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Person execute(UUID id) throws EntityNotFoundException {
        final var result = repository.findById(id);

        if (result.isEmpty())
            throw new EntityNotFoundException(
                    CustomExceptionEnum.DCA2002.getCode(),
                    CustomExceptionEnum.DCA2002.getMessage()
            );

        return modelMapper.map(result.get(), Person.class);
    }
}
