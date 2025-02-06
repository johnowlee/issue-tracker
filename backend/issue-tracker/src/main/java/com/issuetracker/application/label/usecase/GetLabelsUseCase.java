package com.issuetracker.application.label.usecase;

import com.issuetracker.core.label.domain.model.Label;
import com.issuetracker.core.label.domain.service.LabelQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetLabelsUseCase {

    private final LabelQueryService labelQueryService;

    public List<Label> execute() {
        return labelQueryService.getLabels();
    }
}
