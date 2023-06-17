package br.com.ghbalbuquerque.democleanarch.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Person {

    private UUID id;

    private String name;

    private LocalDate birthdate;
}
