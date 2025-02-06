package com.issuetracker.core.label.infrastructure.adapter;

import com.issuetracker.core.label.domain.model.Label;
import com.issuetracker.core.label.domain.port.LabelCommandPort;
import com.issuetracker.core.label.infrastructure.repository.LabelJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LabelCommandAdapter implements LabelCommandPort {

    private final LabelJpaRepository labelJpaRepository;

    @Override
    public Label saveLabel(Label label) {
        return labelJpaRepository.save(label);
    }

    @Override
    public void deleteLabel(Label label) {
        labelJpaRepository.delete(label);
    }
}
