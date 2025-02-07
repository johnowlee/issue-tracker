package com.issuetracker.representer.issue.dto.request;

import java.util.Set;

public record ModifyIssueAssigneesRequest(Set<Long> assigneeIds) {
}
