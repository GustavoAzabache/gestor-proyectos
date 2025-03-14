package com.me.project_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.me.project_manager.entity.ProjectEntity;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

    boolean existsByUrlProject(String urlProject);

}
