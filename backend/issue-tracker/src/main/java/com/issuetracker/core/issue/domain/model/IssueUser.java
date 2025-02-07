package com.issuetracker.core.issue.domain.model;

import com.issuetracker.core.user.domain.model.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "issue_user")
@IdClass(IssueUserId.class)
public class IssueUser {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issue_id")
    private Issue issue;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public IssueUser(Issue issue, User user) {
        this.issue = issue;
        this.user = user;
    }

    public static IssueUser create() {
        return builder().build();
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
        issue.addAssignee(this);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void unsetIssue() {
        this.issue.getAssignees().remove(this);
        this.issue = null;
    }
}