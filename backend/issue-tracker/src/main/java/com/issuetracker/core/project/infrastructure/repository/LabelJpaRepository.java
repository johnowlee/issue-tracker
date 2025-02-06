package com.issuetracker.core.project.infrastructure.repository;

import com.issuetracker.core.project.domain.model.Label;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LabelJpaRepository extends JpaRepository<Label, Long> {
    Optional<Label> findByName(String name);
}
