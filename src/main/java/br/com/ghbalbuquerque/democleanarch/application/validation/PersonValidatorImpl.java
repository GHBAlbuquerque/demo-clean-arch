package br.com.ghbalbuquerque.democleanarch.application.validation;

import br.com.ghbalbuquerque.democleanarch.application.exception.CustomExceptionEnum;
import br.com.ghbalbuquerque.democleanarch.application.exception.model.CustomError;
import br.com.ghbalbuquerque.democleanarch.domain.entity.Person;
import br.com.ghbalbuquerque.democleanarch.domain.validation.PersonValidator;
import br.com.ghbalbuquerque.democleanarch.domain.validation.ValidationResult;
import br.com.ghbalbuquerque.democleanarch.infrastructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonValidatorImpl implements PersonValidator {

    @Autowired
    private PersonRepository repository;

    @Override
    public ValidationResult validate(Person person) {
        final var validationResult = new ValidationResult();
        var name = person.getName();

        if (nameAlreadySet(name)) {
            validationResult.getErrors().add(
                    new CustomError(
                            CustomExceptionEnum.DCA1001.getCode(),
                            CustomExceptionEnum.DCA1002.getMessage(),
                            "name",
                            name
                    )
            );
        }

        validationResult.setIsValid(validationResult.getErrors().isEmpty());
        return validationResult;
    }

    private boolean nameAlreadySet(final String name) {
        var person = repository.findByName(name);

        return person.isPresent();
    }

}
