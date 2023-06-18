package br.com.ghbalbuquerque.democleanarch.application.command;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreatePersonCommand {

    String name;

    LocalDate birthdate;
}
