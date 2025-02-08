package com.issuetracker.application.issue.mapper;

import com.issuetracker.application.issue.data.command.*;
import com.issuetracker.core.issue.domain.service.dto.*;
import org.springframework.stereotype.Component;

@Component
public class IssueUseCaseMapper {

    public CreateIssueInfo toCreateIssueInfo(CreateIssueCommand command) {
        return new CreateIssueInfo(
                command.projectId(),
                command.userId(),
                command.title(),
                command.description(),
                command.startDate(),
                command.endDate(),
                command.assigneeIds(),
                command.labelIds())
        ;
    }

    public ModifyIssueInfo toModifyIssueCommand(ModifyIssueCommand command) {
        return new ModifyIssueInfo(
                command.issueId(),
                command.userId(),
                command.title(),
                command.description(),
                command.startDate(),
                command.endDate()
        );
    }

    public ChangeIssueStatusInfo toChangeIssueStatusInfo(ChangeIssueStatusCommand command) {
        return new ChangeIssueStatusInfo(command.issueId(), command.userId(), command.status());
    }

    public ModifyIssueLabelsInfo toModifyIssueLabelsInfo(ModifyIssueLabelsCommand command) {
        return new ModifyIssueLabelsInfo(command.issueId(), command.userId(), command.labelIds());
    }

    public ModifyIssueAssigneesInfo toModifyIssueAssigneesInfo(ModifyIssueAssigneesCommand command) {
        return new ModifyIssueAssigneesInfo(command.issueId(), command.userId(), command.assigneeIds());
    }
}
