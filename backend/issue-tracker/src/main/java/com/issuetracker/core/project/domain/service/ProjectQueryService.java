package com.issuetracker.core.project.domain.service;

import com.issuetracker.core.project.domain.model.Issue;
import com.issuetracker.core.project.domain.model.Label;
import com.issuetracker.core.project.domain.model.Project;
import com.issuetracker.core.project.domain.port.ProjectQueryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProjectQueryService {

    private final ProjectQueryPort projectQueryPort;

    // TODO: 2025-02-05 예외처리
    public Project getProjectById(long projectId) {
        return projectQueryPort.findProjectById(projectId)
                .orElseThrow(NoSuchElementException::new);
    }

    // TODO: 2025-02-05 예외처리
    public Issue getIssueById(long issueId) {
        return projectQueryPort.findIssueById(issueId)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Label> getLabels() {
        return projectQueryPort.findAll();
    }

    public Label getLabelById(long labelId) {
        return projectQueryPort.findLabelById(labelId)
                .orElseThrow(NoSuchElementException::new);
    }
}
