package br.com.ghbalbuquerque.democleanarch.application.command;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class UpdatePersonCommand {

    UUID id;

    String name;

    LocalDate birthdate;
}
