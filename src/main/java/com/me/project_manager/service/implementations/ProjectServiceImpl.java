package com.me.project_manager.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.project_manager.entity.ProjectEntity;
import com.me.project_manager.exception.ProjectNotFoundException;
import com.me.project_manager.exception.ProjectUrlAlreadyExistsException;
import com.me.project_manager.repository.ProjectRepository;
import com.me.project_manager.service.interfaces.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<ProjectEntity> findAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public ProjectEntity findProjectById(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("El proyecto con ID: " + id + " no existe."));
    }

    @Override
    public ProjectEntity createProject(ProjectEntity projectEntity) {

        if (projectRepository.existsByUrlProject(projectEntity.getUrlProject())) {
            throw new ProjectUrlAlreadyExistsException("Un proyecto con la URL ingresada ya existe");
        }

        return projectRepository.save(projectEntity);
    }

    @Override
    public ProjectEntity updateProject(Long id, ProjectEntity projectEntity) {

        ProjectEntity currentProject = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("El proyecto con ID: " + id + " no existe."));

        // si son diferentes url tiene que comprobar si la nueva url ya está siendo
        // ocupada
        if (!currentProject.getUrlProject().equals(projectEntity.getUrlProject())
                && projectRepository.existsByUrlProject(projectEntity.getUrlProject())) {
            throw new ProjectUrlAlreadyExistsException("Un proyecto con la URL ingresada ya existe");
        }

        currentProject.setName(projectEntity.getName());
        currentProject.setDescription(projectEntity.getDescription());
        currentProject.setUrlProject(projectEntity.getUrlProject());
        currentProject.setState(projectEntity.getState());

        return projectRepository.save(currentProject);
    }

    @Override
    public void deleteProject(Long id) {
        ProjectEntity currentProject = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException("El proyecto con ID: " + id + " no existe."));

        projectRepository.delete(currentProject);
    }

}
