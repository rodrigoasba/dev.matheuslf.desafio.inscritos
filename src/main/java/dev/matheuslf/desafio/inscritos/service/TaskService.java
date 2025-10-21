package dev.matheuslf.desafio.inscritos.service;

import dev.matheuslf.desafio.inscritos.dto.TaskResponseDTO;
import dev.matheuslf.desafio.inscritos.dto.TaskRequestDTO;
import dev.matheuslf.desafio.inscritos.entity.Project;
import dev.matheuslf.desafio.inscritos.entity.Task;
import dev.matheuslf.desafio.inscritos.repository.ProjectRepository;
import dev.matheuslf.desafio.inscritos.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    public TaskService(TaskRepository taskRepository, ProjectRepository projectRepository){
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    public TaskResponseDTO create (TaskRequestDTO dto){

        Optional<Project> project = projectRepository.findById(dto.getProjectId());
        if(project.isEmpty()){
            return null;
        }

        Task task = new Task();
        task.setProject(project.get());
        task.setTitle(dto.getTitle());
        task.setStatus(dto.getStatus());
        task.setDescription(dto.getDescription());
        task.setPriority(dto.getPriority());
        task.setDueDate(dto.getDueDate());

        Task save = taskRepository.save(task);

        return toResponseDTO(save);
    }

    private TaskResponseDTO toResponseDTO(Task task){
        TaskResponseDTO dto = new TaskResponseDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus());
        dto.setPriority(task.getPriority());
        dto.setDueDate(task.getDueDate());
        return dto;
    }

}
