package com.issuetracker.core.project.infrastructure.repository;

import com.issuetracker.core.project.domain.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectJpaRepository extends JpaRepository<Project, Long> {
}
