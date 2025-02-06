package com.issuetracker.core.issue.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IssueLabelId implements Serializable {

    private Long issue;
    private Long label;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        IssueLabelId that = (IssueLabelId) object;
        return Objects.equals(issue, that.issue) && Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issue, label);
    }
}
