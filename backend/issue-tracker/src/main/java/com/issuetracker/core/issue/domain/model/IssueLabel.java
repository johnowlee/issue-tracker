package com.issuetracker.core.issue.domain.model;

import com.issuetracker.core.label.domain.model.Label;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "issue_label")
@IdClass(IssueLabelId.class)
public class IssueLabel {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "issue_id")
    private Issue issue;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "label_id")
    private Label label;

    @Builder
    public IssueLabel(Issue issue, Label label) {
        this.issue = issue;
        this.label = label;
    }

    public static IssueLabel create() {
        return builder().build();
    }

    public void setIssue(Issue issue) {
        this.issue = issue;
        issue.addLabel(this);
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public void unsetIssue() {
        this.issue.getIssueLabels().remove(this);
        this.issue = null;
    }
}