package com.issuetracker.core.project.domain.model;

import com.issuetracker.core.user.domain.model.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "assignee")
@IdClass(AssigneeId.class)
public class Assignee {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issue_id")
    private Issue issue;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Assignee(Issue issue, User user) {
        this.issue = issue;
        this.user = user;
    }

    public static Assignee create(Issue issue, User user) {
        Assignee assignee = builder().build();
        assignee.setIssue(issue);
        assignee.setUser(user);
        return assignee;
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
        issue.addAssignee(this);
    }

    public void setUser(User user) {
        this.user = user;
    }
}