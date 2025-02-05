package com.issuetracker.core.project.infrastructure.adapter;

import com.issuetracker.core.project.domain.model.Issue;
import com.issuetracker.core.project.domain.model.Project;
import com.issuetracker.core.project.domain.port.ProjectQueryPort;
import com.issuetracker.core.project.infrastructure.repository.IssueJpaRepository;
import com.issuetracker.core.project.infrastructure.repository.ProjectJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProjectQueryAdapter implements ProjectQueryPort {

    private final ProjectJpaRepository projectJpaRepository;
    private final IssueJpaRepository issueJpaRepository;

    @Override
    public Optional<Project> findProjectById(Long id) {
        return projectJpaRepository.findById(id);
    }

    @Override
    public Optional<Issue> findIssueById(Long id) {
        return issueJpaRepository.findById(id);
    }
}
