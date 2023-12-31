package com.rh.rhze.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FuncionariosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeidentifier;

    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name = "salario")
    private float salary;

    @Column(name = "cargo")
    private  String office;

    @Column(name = "data_contratacao", columnDefinition = "TIMESTAMP")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime datehiring;

    @Column(name = "horas_mes")
    private int hoursMount;

    @Column(name = "horas_extras")
    private int overtime;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "senha")
    private String password;

    @Column(name = "telefone")
    private String telephone;

    @Column(name = "data_nascimento", columnDefinition = "DATE")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthdate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
    @PrePersist
    public void prePersist(){
        if (datehiring == null){
            datehiring = LocalDateTime.now();
        }
    }

    public enum Status{
        ATIVO,
        INATIVO,
        EM_FERIAS,
        FOLGA,
        LICENCA;
    }

}
