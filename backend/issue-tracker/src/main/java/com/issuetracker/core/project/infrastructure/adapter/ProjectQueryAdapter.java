package com.issuetracker.core.project.infrastructure.adapter;

import com.issuetracker.core.project.domain.model.Issue;
import com.issuetracker.core.project.domain.model.Label;
import com.issuetracker.core.project.domain.model.Project;
import com.issuetracker.core.project.domain.port.ProjectQueryPort;
import com.issuetracker.core.project.infrastructure.repository.IssueJpaRepository;
import com.issuetracker.core.project.infrastructure.repository.LabelJpaRepository;
import com.issuetracker.core.project.infrastructure.repository.ProjectJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProjectQueryAdapter implements ProjectQueryPort {

    private final ProjectJpaRepository projectJpaRepository;
    private final IssueJpaRepository issueJpaRepository;
    private final LabelJpaRepository labelJpaRepository;

    @Override
    public Optional<Project> findProjectById(Long id) {
        return projectJpaRepository.findById(id);
    }

    @Override
    public Optional<Issue> findIssueById(Long id) {
        return issueJpaRepository.findById(id);
    }

    @Override
    public List<Label> findAll() {
        return labelJpaRepository.findAll();
    }

    @Override
    public Optional<Label> findLabelById(long id) {
        return labelJpaRepository.findById(id);
    }

    @Override
    public Optional<Label> findLabelByName(String name) {
        return labelJpaRepository.findByName(name);
    }
}
