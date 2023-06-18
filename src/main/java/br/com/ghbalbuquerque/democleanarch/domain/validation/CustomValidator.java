package br.com.ghbalbuquerque.democleanarch.domain.validation;

public interface CustomValidator<T> {

    ValidationResult validate(T object);
}
