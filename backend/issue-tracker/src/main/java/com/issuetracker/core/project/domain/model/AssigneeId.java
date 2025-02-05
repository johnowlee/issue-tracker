package com.issuetracker.core.project.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AssigneeId implements Serializable {

    private Long issue;
    private Long user;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        AssigneeId that = (AssigneeId) object;
        return Objects.equals(issue, that.issue) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issue, user);
    }
}
