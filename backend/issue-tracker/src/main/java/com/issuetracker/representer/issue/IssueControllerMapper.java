package com.issuetracker.representer.issue;

import com.issuetracker.application.issue.data.command.CreateIssueCommand;
import com.issuetracker.application.issue.data.command.ModifyIssueCommand;
import com.issuetracker.core.issue.domain.model.Issue;
import com.issuetracker.core.issue.domain.model.IssueLabel;
import com.issuetracker.representer.common.CommonControllerMapper;
import com.issuetracker.representer.issue.dto.request.CreateIssueRequest;
import com.issuetracker.representer.issue.dto.request.ModifyIssueRequest;
import com.issuetracker.representer.issue.dto.response.IssueDetailResponse;
import org.springframework.stereotype.Component;

@Component
public class IssueControllerMapper extends CommonControllerMapper {

    public IssueDetailResponse toGetIssueResponse(Issue issue) {
        return new IssueDetailResponse(
                toIssueResponse(issue),
                toProjectResponse(issue.getProject()),
                toUserResponseList(issue.getAssignees()),
                issue.getIssueLabels().stream()
                        .map(IssueLabel::getLabel)
                        .map(this::toLabelResponse)
                        .toList()
        );
    }

    public CreateIssueCommand toCreateIssueCommand(CreateIssueRequest request) {
        return new CreateIssueCommand(
                request.projectId(),
                request.userId(),
                request.title(),
                request.description(),
                request.startDate(),
                request.endDate(),
                request.assigneeIds(),
                request.labelIds()
        );
    }

    public ModifyIssueCommand toModifyIssueCommand(long id, ModifyIssueRequest request) {
        return new ModifyIssueCommand(
                id,
                request.userId(),
                request.title(),
                request.description(),
                request.startDate(),
                request.endDate()
        );
    }
}
