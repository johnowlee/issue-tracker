package com.issuetracker.core.label.domain.port;

import com.issuetracker.core.label.domain.model.Label;

public interface LabelCommandPort {

    Label saveLabel(Label label);

    void deleteLabel(Label label);
}
