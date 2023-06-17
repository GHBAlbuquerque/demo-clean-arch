package br.com.ghbalbuquerque.democleanarch.domain.usecase;

import br.com.ghbalbuquerque.democleanarch.domain.entity.Person;

import java.util.List;

public interface ListAllPersonsUseCase {

    List<Person> execute();
}
