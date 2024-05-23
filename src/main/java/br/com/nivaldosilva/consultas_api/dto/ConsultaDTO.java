package br.com.nivaldosilva.consultas_api.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ConsultaDTO {

    private Long id;

    @NotBlank
    private String paciente;

    @NotBlank
    private String medico;

    @NotNull(message = "Data da consulta é obrigatória")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataConsulta;

    @NotNull(message = "Hora da consulta é obrigatória")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime horaConsulta;
}
