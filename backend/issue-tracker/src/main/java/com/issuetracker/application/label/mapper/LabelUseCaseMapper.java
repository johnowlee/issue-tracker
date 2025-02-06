package com.issuetracker.application.label.mapper;

import com.issuetracker.application.label.data.command.ModifyLabelCommand;
import com.issuetracker.core.label.domain.service.dto.ModifyLabelInfo;
import org.springframework.stereotype.Component;

@Component
public class LabelUseCaseMapper {

    public ModifyLabelInfo toModifyLabelInfo(ModifyLabelCommand command) {
        return new ModifyLabelInfo(command.id(), command.name());
    }
}
