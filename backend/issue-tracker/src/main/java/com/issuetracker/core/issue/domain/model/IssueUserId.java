package com.issuetracker.core.issue.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IssueUserId implements Serializable {

    private Long issue;
    private Long user;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        IssueUserId that = (IssueUserId) object;
        return Objects.equals(issue, that.issue) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issue, user);
    }
}
