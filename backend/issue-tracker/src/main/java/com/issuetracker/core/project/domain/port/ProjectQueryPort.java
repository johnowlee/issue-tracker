package com.issuetracker.core.project.domain.port;

import com.issuetracker.core.project.domain.model.Issue;
import com.issuetracker.core.project.domain.model.Label;
import com.issuetracker.core.project.domain.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectQueryPort {
    Optional<Project> findProjectById(Long id);

    Optional<Issue> findIssueById(Long id);

    List<Label> findAll();

    Optional<Label> findLabelById(long id);
}
