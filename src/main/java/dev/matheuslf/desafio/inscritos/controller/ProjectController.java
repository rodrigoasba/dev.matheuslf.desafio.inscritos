package dev.matheuslf.desafio.inscritos.controller;

import dev.matheuslf.desafio.inscritos.dto.ProjectRequestDTO;
import dev.matheuslf.desafio.inscritos.dto.ProjectResponseDTO;
import dev.matheuslf.desafio.inscritos.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping
    public List<ProjectResponseDTO> findAll(){
        return projectService.findAll();
    }

    @PostMapping
    public ProjectResponseDTO create(@RequestBody @Valid ProjectRequestDTO dto){
        return projectService.create(dto);
    }




}
