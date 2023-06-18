package br.com.ghbalbuquerque.democleanarch.application.usecase;

import br.com.ghbalbuquerque.democleanarch.application.command.CreatePersonCommand;
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
    public Person execute(CreatePersonCommand command) {
        var person = modelMapper.map(command, Person.class);

        var validationResult = validator.validate(person);

        if (!validationResult.getIsValid()) {
            validationResult.getErrors().forEach(
                    error -> notificationContext.addNotification(
                            error.getCode(), error.getMessage()
                    )
            );
            return null;
        }

        var pessoaEntity = modelMapper.map(person, PersonEntity.class);

        var newPerson = personRepository.save(pessoaEntity);

        return modelMapper.map(newPerson, Person.class);
    }
}
