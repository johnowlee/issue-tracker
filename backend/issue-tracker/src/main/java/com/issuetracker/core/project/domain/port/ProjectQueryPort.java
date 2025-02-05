package com.issuetracker.core.project.domain.port;

import com.issuetracker.core.project.domain.model.Project;

import java.util.Optional;

public interface ProjectQueryPort {
    Optional<Project> findById(Long id);
}
