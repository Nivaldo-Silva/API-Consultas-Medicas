package br.com.nivaldosilva.consultas_api.model;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "tb_consultas")
@Data
public class ConsultaEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    
    @Column(name = "paciente",nullable = false)
    private String paciente;

    
    @Column(name = "medico",nullable = false)
    private String medico;

   
    @NotNull(message = "Data da consulta é obrigatória") 
    @Column(name = "data da consulta")
    private LocalDate dataConsulta;

    
    @NotNull(message = "Hora da consulta é obrigatória")
    @Column(name = "hora da consulta")
    private LocalTime horaConsulta;

    

    

   

}
