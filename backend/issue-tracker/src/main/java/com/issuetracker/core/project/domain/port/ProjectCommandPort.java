package com.issuetracker.core.project.domain.port;

import com.issuetracker.core.project.domain.model.Issue;
import com.issuetracker.core.project.domain.model.Label;
import com.issuetracker.core.project.domain.model.Project;

public interface ProjectCommandPort {
    Project saveProject(Project project);

    Issue saveIssue(Issue issue);

    Label saveLabel(Label label);

    void deleteLabel(Label label);
}
