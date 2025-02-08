package com.issuetracker.application.label.mapper;

import com.issuetracker.application.label.data.command.DeleteLabelCommand;
import com.issuetracker.application.label.data.command.ModifyLabelCommand;
import com.issuetracker.core.label.domain.service.dto.ModifyLabelInfo;
import com.issuetracker.core.project.domain.service.dto.DeleteLabelInfo;
import org.springframework.stereotype.Component;

@Component
public class LabelUseCaseMapper {

    public ModifyLabelInfo toModifyLabelInfo(ModifyLabelCommand command) {
        return new ModifyLabelInfo(command.labelId(), command.name(), command.userId());
    }

    public DeleteLabelInfo toDeleteLabelInfo(DeleteLabelCommand command) {
        return new DeleteLabelInfo(command.labelId(), command.userId());
    }
}
