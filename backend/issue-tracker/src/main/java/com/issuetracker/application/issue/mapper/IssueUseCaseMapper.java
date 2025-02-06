package com.issuetracker.application.issue.mapper;

import com.issuetracker.application.issue.data.command.CreateIssueCommand;
import com.issuetracker.core.issue.domain.service.dto.CreateIssueInfo;
import org.springframework.stereotype.Component;

@Component
public class IssueUseCaseMapper {

    public CreateIssueInfo toCreateIssueInfo(CreateIssueCommand command) {
        return new CreateIssueInfo(
                command.projectId(),
                command.title(),
                command.description(),
                command.startDateTime(),
                command.endDateTime(),
                command.assigneeIds(),
                command.labelIds())
        ;
    }
}
