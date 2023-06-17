package br.com.ghbalbuquerque.democleanarch.api.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<?> getPersons(){
        return ResponseEntity.ok().build();
    }

}
