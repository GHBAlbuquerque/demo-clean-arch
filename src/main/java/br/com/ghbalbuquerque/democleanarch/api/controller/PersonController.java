package br.com.ghbalbuquerque.democleanarch.api.controller;

import br.com.ghbalbuquerque.democleanarch.api.request.PersonCreationDTO;
import br.com.ghbalbuquerque.democleanarch.api.request.PersonUpdateDTO;
import br.com.ghbalbuquerque.democleanarch.api.response.PersonResponseDTO;
import br.com.ghbalbuquerque.democleanarch.application.command.CreatePersonCommand;
import br.com.ghbalbuquerque.democleanarch.application.command.UpdatePersonCommand;
import br.com.ghbalbuquerque.democleanarch.application.exception.custom.CreateEntityException;
import br.com.ghbalbuquerque.democleanarch.application.exception.custom.EntityNotFoundException;
import br.com.ghbalbuquerque.democleanarch.domain.usecase.CreatePersonUseCase;
import br.com.ghbalbuquerque.democleanarch.domain.usecase.GetPersonByIdUseCase;
import br.com.ghbalbuquerque.democleanarch.domain.usecase.ListAllPersonsUseCase;
import br.com.ghbalbuquerque.democleanarch.domain.usecase.UpdatePersonUseCase;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private ListAllPersonsUseCase listAllPersonsUseCase;

    @Autowired
    private GetPersonByIdUseCase getPersonByIdUseCase;

    @Autowired
    private CreatePersonUseCase createPersonUseCase;

    @Autowired
    private UpdatePersonUseCase updatePersonUseCase;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<Page<PersonResponseDTO>> listAll(Pageable pageable) {
        final var result = listAllPersonsUseCase.execute(pageable);
        final var response = result.map(
                person -> modelMapper.map(person, PersonResponseDTO.class)
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponseDTO> getPersonById(@PathVariable UUID id) throws EntityNotFoundException {
        final var result = getPersonByIdUseCase.execute(id);
        var response = modelMapper.map(result, PersonResponseDTO.class);

        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<PersonResponseDTO> createPerson(@RequestBody PersonCreationDTO personCreationDTO)
            throws CreateEntityException {
        final var command = modelMapper.map(personCreationDTO, CreatePersonCommand.class);
        final var result = createPersonUseCase.execute(command);
        var response = modelMapper.map(result, PersonResponseDTO.class);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonResponseDTO> updatePerson(@PathVariable UUID id, @RequestBody PersonUpdateDTO personUpdateDTO)
            throws CreateEntityException, EntityNotFoundException {
        final var command = modelMapper.map(personUpdateDTO, UpdatePersonCommand.class);
        final var result = updatePersonUseCase.execute(id, command);
        var response = modelMapper.map(result, PersonResponseDTO.class);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable UUID id) {
        //TODO
        return ResponseEntity.ok().build();
    }

}
