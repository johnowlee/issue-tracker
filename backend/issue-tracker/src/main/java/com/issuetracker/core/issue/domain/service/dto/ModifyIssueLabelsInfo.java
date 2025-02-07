package com.issuetracker.core.issue.domain.service.dto;

import java.util.Set;

public record ModifyIssueLabelsInfo(long id, Set<Long> labelIds) {
}
