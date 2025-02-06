package com.issuetracker.core.label.infrastructure.adapter;

import com.issuetracker.core.label.domain.model.Label;
import com.issuetracker.core.label.domain.port.LabelQueryPort;
import com.issuetracker.core.label.infrastructure.repository.LabelJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LabelQueryAdapter implements LabelQueryPort {

    private final LabelJpaRepository labelJpaRepository;

    @Override
    public List<Label> findAll() {
        return labelJpaRepository.findAll();
    }

    @Override
    public Optional<Label> findLabelById(long id) {
        return labelJpaRepository.findById(id);
    }

    @Override
    public Optional<Label> findLabelByName(String name) {
        return labelJpaRepository.findByName(name);
    }
}
