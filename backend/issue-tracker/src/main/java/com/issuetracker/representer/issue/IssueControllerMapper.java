package com.issuetracker.representer.issue;

import com.issuetracker.application.issue.data.command.CreateIssueCommand;
import com.issuetracker.core.issue.domain.model.Issue;
import com.issuetracker.core.issue.domain.model.IssueLabel;
import com.issuetracker.representer.common.CommonControllerMapper;
import com.issuetracker.representer.issue.dto.request.CreateIssueRequest;
import com.issuetracker.representer.issue.dto.response.CreateIssueResponse;
import com.issuetracker.representer.issue.dto.response.GetIssueResponse;
import org.springframework.stereotype.Component;

@Component
public class IssueControllerMapper extends CommonControllerMapper {

    public GetIssueResponse toGetIssueResponse(Issue issue) {
        return new GetIssueResponse(
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
                request.title(),
                request.description(),
                request.startDateTime(),
                request.endDateTime(),
                request.assigneeIds(),
                request.labelIds()
        );
    }

    public CreateIssueResponse toCreateIssueResponse(Issue issue) {
        return new CreateIssueResponse(
                toIssueResponse(issue),
                toUserResponseList(issue.getAssignees())
        );
    }
}
