package com.issuetracker.core.label.domain.service;

import com.issuetracker.core.label.domain.model.Label;
import com.issuetracker.core.label.domain.port.LabelQueryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class LabelQueryService {

    private final LabelQueryPort labelQueryPort;

    public List<Label> getLabels() {
        return labelQueryPort.findAll();
    }

    public Label getLabelById(long labelId) {
        return labelQueryPort.findLabelById(labelId)
                .orElseThrow(NoSuchElementException::new);
    }

    public boolean isLabelPresentByName(String labelName) {
        return labelQueryPort.findLabelByName(labelName).isPresent();
    }
}
