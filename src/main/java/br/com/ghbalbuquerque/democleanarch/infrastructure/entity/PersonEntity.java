package br.com.ghbalbuquerque.democleanarch.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_person")
public class PersonEntity {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private LocalDate birthdate;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
