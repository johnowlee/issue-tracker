package com.issuetracker.core.project.infrastructure.repository;

import com.issuetracker.core.project.domain.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueJpaRepository extends JpaRepository<Issue, Long> {
}
