package com.issuetracker.core.issue.domain.port;


import com.issuetracker.core.issue.domain.model.Issue;

import java.util.Optional;

public interface IssueQueryPort {

    Optional<Issue> findIssueById(Long id);
}
