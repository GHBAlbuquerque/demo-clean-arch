package br.com.ghbalbuquerque.democleanarch.application.validation;

import br.com.ghbalbuquerque.democleanarch.application.exception.CustomExceptionEnum;
import br.com.ghbalbuquerque.democleanarch.application.exception.model.CustomError;
import br.com.ghbalbuquerque.democleanarch.domain.entity.Person;
import br.com.ghbalbuquerque.democleanarch.domain.validation.PersonValidator;
import br.com.ghbalbuquerque.democleanarch.domain.validation.ValidationResult;
import br.com.ghbalbuquerque.democleanarch.infrastructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class PersonValidatorImpl implements PersonValidator {

    @Autowired
    private PersonRepository repository;

    private ValidationResult validationResult = new ValidationResult();


    @Override
    public ValidationResult validate(Person person) {

        validateUniqueName(person.getName());
        validateAgeOver18(person.getBirthdate());

        validationResult.setIsValid(validationResult.getErrors().isEmpty());
        return validationResult;
    }

    private void validateUniqueName(final String name) {
        var person = repository.findByName(name);

        if (person.isPresent()) {
            validationResult.getErrors().add(
                    new CustomError(
                            CustomExceptionEnum.DCA1001.getCode(),
                            CustomExceptionEnum.DCA1001.getMessage(),
                            "name",
                            name
                    )
            );
        }
    }

    private void validateAgeOver18(final LocalDate birthdate) {
        var currentDate = LocalDate.now();
        var age = ChronoUnit.YEARS.between(birthdate, currentDate);

        if (age < 18L) {
            validationResult.getErrors().add(
                    new CustomError(
                            CustomExceptionEnum.DCA1002.getCode(),
                            CustomExceptionEnum.DCA1002.getMessage(),
                            "birthdate",
                            birthdate
                    )
            );
        }
    }

}
