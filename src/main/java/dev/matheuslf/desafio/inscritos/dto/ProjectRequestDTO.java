package dev.matheuslf.desafio.inscritos.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProjectRequestDTO {
    @NotBlank(message = "O nome do projeto é obrigatório")
    private String name;
    private String description;
    private LocalDateTime endDate;
    private List<TaskRequestDTO> task;
}
