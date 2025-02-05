package com.issuetracker.core.project.domain.port;

import com.issuetracker.core.project.domain.model.Project;

public interface ProjectCommandPort {
    Project save(Project project);

    Project createIssue(Project project);
}
