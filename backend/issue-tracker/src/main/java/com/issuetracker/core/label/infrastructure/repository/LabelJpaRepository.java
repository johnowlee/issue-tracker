package com.issuetracker.core.label.infrastructure.repository;

import com.issuetracker.core.label.domain.model.Label;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LabelJpaRepository extends JpaRepository<Label, Long> {
    Optional<Label> findByName(String name);
}
