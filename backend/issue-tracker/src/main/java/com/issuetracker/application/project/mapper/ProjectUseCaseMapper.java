package com.issuetracker.application.project.mapper;

import com.issuetracker.application.project.data.command.CreateIssueCommand;
import com.issuetracker.application.project.data.command.CreateProjectCommand;
import com.issuetracker.application.project.data.command.ModifyLabelCommand;
import com.issuetracker.core.project.domain.service.dto.CreateIssueInfo;
import com.issuetracker.core.project.domain.service.dto.CreateProjectInfo;
import com.issuetracker.core.project.domain.service.dto.ModifyLabelInfo;
import org.springframework.stereotype.Component;

@Component
public class ProjectUseCaseMapper {
    public CreateProjectInfo toCreateProjectInfo(CreateProjectCommand command) {
        return new CreateProjectInfo(command.managerId(), command.title(), command.description());
    }

    public CreateIssueInfo toCreateIssueInfo(CreateIssueCommand command) {
        return new CreateIssueInfo(
                command.projectId(),
                command.title(),
                command.description(),
                command.startDateTime(),
                command.endDateTime(),
                command.assigneeIds(),
                command.labelIds()
        );
    }

    public ModifyLabelInfo toModifyLabelInfo(ModifyLabelCommand command) {
        return new ModifyLabelInfo(command.id(), command.name());
    }
}
