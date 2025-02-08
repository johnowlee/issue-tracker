package com.issuetracker.core.issue.domain.service.dto;

import java.util.Set;

public record ModifyIssueAssigneesInfo(long issueId, long userId, Set<Long> assigneeIds) {
}
