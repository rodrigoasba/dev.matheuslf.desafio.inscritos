package dev.matheuslf.desafio.inscritos.dto;

import dev.matheuslf.desafio.inscritos.entity.Priority;
import dev.matheuslf.desafio.inscritos.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskResponseDTO {
    private Long id;
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private LocalDateTime dueDate;
    private Long projectId;
}
