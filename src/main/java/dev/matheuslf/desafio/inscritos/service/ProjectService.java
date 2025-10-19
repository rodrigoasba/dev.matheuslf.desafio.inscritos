package dev.matheuslf.desafio.inscritos.service;

import dev.matheuslf.desafio.inscritos.dto.ProjectRequestDTO;
import dev.matheuslf.desafio.inscritos.dto.ProjectResponseDTO;
import dev.matheuslf.desafio.inscritos.dto.TaskResponseDTO;
import dev.matheuslf.desafio.inscritos.entity.Project;
import dev.matheuslf.desafio.inscritos.entity.Task;
import dev.matheuslf.desafio.inscritos.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository = projectRepository;
    }

    public ProjectResponseDTO create(ProjectRequestDTO dto){
        Project project = new Project();
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setEndDate(dto.getEndDate());

        if(dto.getTasks() != null && !dto.getTasks().isEmpty()) {
            List<Task> tasks = dto.getTasks().stream().map(taskDTO -> {
                Task task = new Task();
                task.setTitle(taskDTO.getTitle());
                task.setDescription(taskDTO.getDescription());
                task.setPriority(taskDTO.getPriority());
                task.setStatus(taskDTO.getStatus());
                task.setDueDate(taskDTO.getDueDate());
                task.setProject(project);
                return task;
            }).collect(Collectors.toList());
            project.setTasks(tasks);
        }
        return toResponseDTO(projectRepository.save(project));
    }



    private ProjectResponseDTO toResponseDTO(Project project) {
        ProjectResponseDTO dto = new ProjectResponseDTO();
        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setDescription(project.getDescription());
        dto.setStartDate(project.getStartDate());
        dto.setEndDate(project.getEndDate());
        dto.setTasks(
                project.getTasks() != null
                        ? project.getTasks().stream().map(task -> {
                    var taskDTO = new TaskResponseDTO();
                    taskDTO.setId(task.getId());
                    taskDTO.setTitle(task.getTitle());
                    taskDTO.setDescription(task.getDescription());
                    taskDTO.setPriority(task.getPriority());
                    taskDTO.setStatus(task.getStatus());
                    taskDTO.setDueDate(task.getDueDate());
                    return taskDTO;
                }).collect(Collectors.toList()) : null
        );
        return dto;
    }


}
