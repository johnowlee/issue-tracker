package com.issuetracker.core.label.domain.service;

import com.issuetracker.core.label.domain.model.Label;
import com.issuetracker.core.label.domain.port.LabelCommandPort;
import com.issuetracker.core.label.domain.service.dto.CreateLabelInfo;
import com.issuetracker.core.label.domain.service.dto.ModifyLabelInfo;
import com.issuetracker.core.project.domain.service.dto.DeleteLabelInfo;
import com.issuetracker.core.user.domain.model.User;
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
    private final UserQueryService userQueryService;

    // TODO: 2025-02-06  예외처리
    public Label createLabel(CreateLabelInfo info) {
        User user = userQueryService.getUserById(info.userId());
        user.validateAdminRole();

        if (labelQueryService.isLabelPresentByName(info.name())) {
            throw new EntityExistsException();
        }
        Label label = Label.create(info.name());
        return labelCommandPort.saveLabel(label);
    }

    public Label modifyLabel(ModifyLabelInfo info) {
        User user = userQueryService.getUserById(info.userId());
        user.validateAdminRole();

        Label label = labelQueryService.getLabelById(info.labelId());
        label.changeName(info.name());
        return labelCommandPort.saveLabel(label);
    }

    public void deleteLabel(DeleteLabelInfo info) {
        User user = userQueryService.getUserById(info.userId());
        user.validateAdminRole();

        Label label = labelQueryService.getLabelById(info.labelId());
        labelCommandPort.deleteLabel(label);
    }
}
