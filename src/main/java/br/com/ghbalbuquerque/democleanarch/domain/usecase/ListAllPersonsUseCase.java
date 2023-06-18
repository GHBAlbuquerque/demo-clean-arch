package br.com.ghbalbuquerque.democleanarch.domain.usecase;

import br.com.ghbalbuquerque.democleanarch.domain.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ListAllPersonsUseCase {

    Page<Person> execute(Pageable pageable);
}
