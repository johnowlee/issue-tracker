package com.issuetracker.core.project.infrastructure.repository;

import com.issuetracker.core.project.domain.model.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelJpaRepository extends JpaRepository<Label, Long> {
}
