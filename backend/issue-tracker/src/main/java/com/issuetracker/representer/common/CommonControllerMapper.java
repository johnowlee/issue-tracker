package com.issuetracker.representer.common;

import com.issuetracker.core.issue.domain.model.Issue;
import com.issuetracker.core.issue.domain.model.IssueLabel;
import com.issuetracker.core.issue.domain.model.IssueUser;
import com.issuetracker.core.label.domain.model.Label;
import com.issuetracker.core.project.domain.model.Project;
import com.issuetracker.core.user.domain.model.User;
import com.issuetracker.representer.issue.dto.response.IssueResponse;
import com.issuetracker.representer.issue.dto.response.IssueDetailWithoutProjectResponse;
import com.issuetracker.representer.label.dto.response.LabelResponse;
import com.issuetracker.representer.project.dto.response.ProjectResponse;
import com.issuetracker.representer.user.dto.response.UserResponse;

import java.util.List;
import java.util.Set;

public class CommonControllerMapper {

    public ProjectResponse toProjectResponse(Project project) {
        return new ProjectResponse(project.getId(), project.getTitle(), project.getDescription(), project.getStartDate(), project.getEndDate());
    }

    public IssueResponse toIssueResponse(Issue issue) {
        return new IssueResponse(issue.getId(), issue.getTitle(), issue.getDescription(), issue.getStartDate(), issue.getEndDate(), issue.getStatus());
    }

    public IssueDetailWithoutProjectResponse toIssueDetailWithoutProjectResponse(Issue issue) {
        return new IssueDetailWithoutProjectResponse(
                toIssueResponse(issue),
                toUserResponseList(issue.getAssignees()),
                toLabelResponseList(issue.getIssueLabels())
        );
    }

    public LabelResponse toLabelResponse(Label label) {
        return new LabelResponse(label.getId(), label.getName());
    }

    public UserResponse toUserResponse(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }

    private List<LabelResponse> toLabelResponseList(Set<IssueLabel> issueLabels) {
        return issueLabels.stream()
                .map(IssueLabel::getLabel)
                .map(this::toLabelResponse)
                .toList();
    }

    protected List<UserResponse> toUserResponseList(Set<IssueUser> issueUsers) {
        return issueUsers.stream()
                .map(IssueUser::getUser)
                .map(this::toUserResponse)
                .toList();
    }
}
