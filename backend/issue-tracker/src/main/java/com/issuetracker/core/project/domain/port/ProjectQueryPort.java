package com.issuetracker.core.project.domain.port;

import com.issuetracker.core.project.domain.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectQueryPort {
    Optional<Project> findProjectById(Long id);

    List<Project> findProjects();
}
