package com.issuetracker.application.issue.mapper;

import com.issuetracker.application.issue.data.command.*;
import com.issuetracker.core.issue.domain.service.dto.*;
import org.springframework.stereotype.Component;

@Component
public class IssueUseCaseMapper {

    public CreateIssueInfo toCreateIssueInfo(CreateIssueCommand command) {
        return new CreateIssueInfo(
                command.projectId(),
                command.title(),
                command.description(),
                command.startDate(),
                command.endDate(),
                command.assigneeIds(),
                command.labelIds())
        ;
    }

    public static ModifyIssueInfo toModifyIssueCommand(ModifyIssueCommand command) {
        return new ModifyIssueInfo(
                command.id(),
                command.title(),
                command.description(),
                command.startDate(),
                command.endDate()
        );
    }

    public ChangeIssueStatusInfo toChangeIssueStatusInfo(ChangeIssueStatusCommand command) {
        return new ChangeIssueStatusInfo(command.id(), command.status());
    }

    public ModifyIssueLabelsInfo toModifyIssueLabelsInfo(ModifyIssueLabelsCommand command) {
        return new ModifyIssueLabelsInfo(command.id(), command.labelIds());
    }

    public ModifyIssueAssigneesInfo toModifyIssueAssigneesInfo(ModifyIssueAssigneesCommand command) {
        return new ModifyIssueAssigneesInfo(command.id(), command.assigneeIds());
    }
}
