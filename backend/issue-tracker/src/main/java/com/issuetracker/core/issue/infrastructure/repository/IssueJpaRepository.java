package com.issuetracker.core.issue.infrastructure.repository;

import com.issuetracker.core.issue.domain.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueJpaRepository extends JpaRepository<Issue, Long> {
}
