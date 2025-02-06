package com.issuetracker.core.project.domain.model;

import com.issuetracker.core.project.domain.service.dto.CreateIssueInfo;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "issue")
public class Issue {

    @Id
    @Column(name = "issue_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private IssueStatus status;

    @ManyToOne
    @JoinColumn(name = "project_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Project project;

    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<IssueUser> assignees = new HashSet<>();

    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<IssueLabel> labels = new HashSet<>();

    @Builder
    public Issue(Long id, String title, String description, LocalDateTime startDateTime, LocalDateTime endDateTime, IssueStatus status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.status = status;
    }

    public static Issue create(CreateIssueInfo createIssueInfo) {
        return Issue.builder()
                .title(createIssueInfo.title())
                .description(createIssueInfo.description())
                .status(IssueStatus.IN_PROGRESS)
                .startDateTime(createIssueInfo.startDateTime())
                .endDateTime(createIssueInfo.endDateTime())
                .build();
    }

    public void setProject(Project project) {
        this.project = project;
        project.addIssue(this);
    }

    public void addAssignee(IssueUser issueUser) {
        this.assignees.add(issueUser);
    }

    public void addlabel(IssueLabel issueUser) {
        this.labels.add(issueUser);
    }
}
