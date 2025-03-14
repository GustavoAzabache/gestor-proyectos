package com.me.project_manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.me.project_manager.entity.ProjectEntity;
import com.me.project_manager.service.interfaces.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/readAll")
    public ResponseEntity<List<ProjectEntity>> findAllProjects() {
        return ResponseEntity.ok(projectService.findAllProjects());
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<ProjectEntity> findProjectById(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.findProjectById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<ProjectEntity> createProject(@RequestBody ProjectEntity projectEntity) {
        return ResponseEntity.ok(projectService.createProject(projectEntity));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProjectEntity> updateProject(@PathVariable Long id,
            @RequestBody ProjectEntity projectEntity) {
        return ResponseEntity.ok(projectService.updateProject(id, projectEntity));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);

        return ResponseEntity.ok("El proyecto ha sido eliminado exitosamente.");
    }

}
