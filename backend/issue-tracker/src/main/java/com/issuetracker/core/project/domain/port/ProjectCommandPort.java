package com.issuetracker.core.project.domain.port;

import com.issuetracker.core.project.domain.model.Project;

public interface ProjectCommandPort {
    Project saveProject(Project project);

    void delete(Project project);
}
