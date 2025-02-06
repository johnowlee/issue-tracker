package com.issuetracker.core.label.domain.service;

import com.issuetracker.core.label.domain.model.Label;
import com.issuetracker.core.label.domain.port.LabelCommandPort;
import com.issuetracker.core.label.domain.service.dto.ModifyLabelInfo;
import com.issuetracker.core.user.domain.service.UserQueryService;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LabelCommandService {

    private final LabelCommandPort labelCommandPort;
    private final LabelQueryService labelQueryService;

    // TODO: 2025-02-06  예외처리
    public Label createLabel(String labelName) {
        if (labelQueryService.isLabelPresentByName(labelName)) {
            throw new EntityExistsException();
        }
        Label label = Label.create(labelName);
        return labelCommandPort.saveLabel(label);
    }

    public Label modifyLabel(ModifyLabelInfo modifyLabelInfo) {
        Label label = labelQueryService.getLabelById(modifyLabelInfo.id());
        label.changeName(modifyLabelInfo.name());
        return labelCommandPort.saveLabel(label);
    }

    public void deleteLabel(long id) {
        Label label = labelQueryService.getLabelById(id);
        labelCommandPort.deleteLabel(label);
    }
}
