package br.com.ghbalbuquerque.democleanarch.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private UUID id;

    private String name;

    private LocalDate birthdate;
}
