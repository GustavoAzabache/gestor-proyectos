package com.me.project_manager.service.interfaces;

import java.util.List;

import com.me.project_manager.entity.ProjectEntity;

public interface ProjectService {

    List<ProjectEntity> findAllProjects();

    ProjectEntity findProjectById(Long id);

    ProjectEntity createProject(ProjectEntity projectEntity);

    ProjectEntity updateProject(Long id, ProjectEntity projectEntity);

    void deleteProject(Long id);

}
