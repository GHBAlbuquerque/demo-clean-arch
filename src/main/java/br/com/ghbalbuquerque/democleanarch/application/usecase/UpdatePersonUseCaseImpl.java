package br.com.ghbalbuquerque.democleanarch.application.usecase;

import br.com.ghbalbuquerque.democleanarch.application.command.UpdatePersonCommand;
import br.com.ghbalbuquerque.democleanarch.application.exception.CustomExceptionEnum;
import br.com.ghbalbuquerque.democleanarch.application.exception.custom.CreateEntityException;
import br.com.ghbalbuquerque.democleanarch.application.exception.custom.EntityNotFoundException;
import br.com.ghbalbuquerque.democleanarch.application.notification.interfaces.NotificationContext;
import br.com.ghbalbuquerque.democleanarch.domain.entity.Person;
import br.com.ghbalbuquerque.democleanarch.domain.usecase.UpdatePersonUseCase;
import br.com.ghbalbuquerque.democleanarch.domain.validation.PersonValidator;
import br.com.ghbalbuquerque.democleanarch.infrastructure.entity.PersonEntity;
import br.com.ghbalbuquerque.democleanarch.infrastructure.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdatePersonUseCaseImpl implements UpdatePersonUseCase {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private NotificationContext notificationContext;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PersonValidator validator;

    @Override
    public Person execute(UUID id, UpdatePersonCommand command) throws EntityNotFoundException, CreateEntityException {
        final var optional = repository.findById(id);

        if(optional.isEmpty()) {
            throw new EntityNotFoundException(
                    CustomExceptionEnum.DCA2002.getCode(),
                    CustomExceptionEnum.DCA2002.getMessage()
            );
        }

        var person = modelMapper.map(command, Person.class);
        person.setId(id);

        var validationResult = validator.validate(person);

        if (!validationResult.getIsValid()) {
            validationResult.getErrors().forEach(
                    error -> notificationContext.addNotification(
                            error.getCode(), error.getMessage()
                    )
            );

            throw new CreateEntityException(
                    CustomExceptionEnum.DCA2001.getCode(),
                    CustomExceptionEnum.DCA2001.getMessage()
            );
        }

        final var entity = optional.get();
        modelMapper.map(person, entity);

        var newPerson = repository.save(entity);

        return modelMapper.map(newPerson, Person.class);
    }

}
