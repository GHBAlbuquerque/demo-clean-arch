package br.com.ghbalbuquerque.democleanarch.application.usecase;

import br.com.ghbalbuquerque.democleanarch.application.command.CreatePersonCommand;
import br.com.ghbalbuquerque.democleanarch.application.exception.CustomExceptionEnum;
import br.com.ghbalbuquerque.democleanarch.application.exception.custom.CreateEntityException;
import br.com.ghbalbuquerque.democleanarch.application.notification.interfaces.NotificationContext;
import br.com.ghbalbuquerque.democleanarch.domain.entity.Person;
import br.com.ghbalbuquerque.democleanarch.domain.usecase.CreatePersonUseCase;
import br.com.ghbalbuquerque.democleanarch.domain.validation.PersonValidator;
import br.com.ghbalbuquerque.democleanarch.infrastructure.entity.PersonEntity;
import br.com.ghbalbuquerque.democleanarch.infrastructure.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePersonUseCaseImpl implements CreatePersonUseCase {

    //TODO: impl

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private NotificationContext notificationContext;

    @Autowired
    private PersonValidator validator;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Person execute(CreatePersonCommand command) throws CreateEntityException {
        var person = modelMapper.map(command, Person.class);

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

        var personEntity = modelMapper.map(person, PersonEntity.class);

        var newPerson = personRepository.save(personEntity);

        return modelMapper.map(newPerson, Person.class);
    }
}
