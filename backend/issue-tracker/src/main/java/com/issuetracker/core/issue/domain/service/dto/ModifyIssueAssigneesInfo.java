package com.issuetracker.core.issue.domain.service.dto;

import java.util.Set;

public record ModifyIssueAssigneesInfo(long id, Set<Long> assigneeIds) {
}
