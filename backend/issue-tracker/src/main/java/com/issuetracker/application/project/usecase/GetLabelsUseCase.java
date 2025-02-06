package com.issuetracker.application.project.usecase;

import com.issuetracker.core.project.domain.model.Label;
import com.issuetracker.core.project.domain.service.ProjectQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetLabelsUseCase {

    private final ProjectQueryService projectQueryService;

    public List<Label> execute() {
        return projectQueryService.getLabels();
    }
}
