package com.issuetracker.core.label.domain.port;

import com.issuetracker.core.label.domain.model.Label;

import java.util.List;
import java.util.Optional;

public interface LabelQueryPort {

    List<Label> findAll();

    Optional<Label> findLabelById(long id);

    Optional<Label> findLabelByName(String name);
}
