package com.issuetracker.core.project.infrastructure.adapter;

import com.issuetracker.core.project.domain.model.Issue;
import com.issuetracker.core.project.domain.model.Label;
import com.issuetracker.core.project.domain.model.Project;
import com.issuetracker.core.project.domain.port.ProjectCommandPort;
import com.issuetracker.core.project.infrastructure.repository.IssueJpaRepository;
import com.issuetracker.core.project.infrastructure.repository.LabelJpaRepository;
import com.issuetracker.core.project.infrastructure.repository.ProjectJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProjectCommandAdapter implements ProjectCommandPort {

    private final ProjectJpaRepository projectJpaRepository;
    private final IssueJpaRepository issueJpaRepository;
    private final LabelJpaRepository labelJpaRepository;

    @Override
    public Project saveProject(Project project) {
        return projectJpaRepository.save(project);
    }

    @Override
    public Issue saveIssue(Issue issue) {
        return issueJpaRepository.save(issue);
    }

    @Override
    public Label saveLabel(Label label) {
        return labelJpaRepository.save(label);
    }
}
