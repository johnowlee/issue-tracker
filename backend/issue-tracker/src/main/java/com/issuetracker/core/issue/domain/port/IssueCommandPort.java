package com.issuetracker.core.issue.domain.port;

import com.issuetracker.core.issue.domain.model.Issue;

public interface IssueCommandPort {

    Issue save(Issue issue);

    void delete(Issue issue);
}
