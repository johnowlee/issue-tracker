package com.issuetracker.core.issue.domain.model;

import com.issuetracker.core.issue.domain.service.dto.CreateIssueInfo;
import com.issuetracker.core.project.domain.model.Project;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    private LocalDate startDate;
    private LocalDate endDate;
    private IssueStatus status;

    @ManyToOne
    @JoinColumn(name = "project_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Project project;

    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<IssueUser> assignees = new HashSet<>();

    @OneToMany(mappedBy = "issue", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<IssueLabel> issueLabels = new HashSet<>();

    @Builder
    public Issue(Long id, String title, String description, LocalDate startDate, LocalDate endDate, IssueStatus status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public static Issue create(CreateIssueInfo createIssueInfo) {
        return Issue.builder()
                .title(createIssueInfo.title())
                .description(createIssueInfo.description())
                .status(IssueStatus.IN_PROGRESS)
                .startDate(createIssueInfo.startDate())
                .endDate(createIssueInfo.endDate())
                .build();
    }

    public void setProject(Project project) {
        this.project = project;
        project.addIssue(this);
    }

    public void addAssignee(IssueUser issueUser) {
        this.assignees.add(issueUser);
    }

    public void addLabel(IssueLabel issueUser) {
        this.issueLabels.add(issueUser);
    }

    // TODO: 2025-02-07  
    public void updateTitle(String title) {
        if (StringUtils.isBlank(title)) {
            throw new IllegalArgumentException("제목은 필수입니다.");
        }
        this.title = title;
    }

    public void updateDescription(String description) {
        this.description = description;
    }

    public void updateStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void updateEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    // TODO: 2025-02-07
    public void changeStatus(IssueStatus status) {
        if (status == null) {
            throw new IllegalArgumentException("상태 값은 필수입니다.");
        }
        this.status = status;
    }
}
