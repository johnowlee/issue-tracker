package com.issuetracker.core.project.domain.model;

import com.issuetracker.core.issue.domain.model.Issue;
import com.issuetracker.core.project.domain.service.dto.CreateProjectInfo;
import com.issuetracker.core.user.domain.model.User;
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
@Table(name = "project")
public class Project {

    @Id
    @Column(name = "project_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private User manager;

    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Issue> issues = new HashSet<>();

    @Builder
    public Project(Long id, String title, String description, LocalDate startDate, LocalDate endDate, Set<Issue> issues) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.issues = issues;
    }

    public static Project from(CreateProjectInfo createProjectInfo) {
        return builder()
                .title(createProjectInfo.title())
                .description(createProjectInfo.description())
                .build();
    }

    public void setManager(User user) {
        this.manager = user;
    }

    public void addIssue(Issue issue) {
        this.issues.add(issue);
    }

    public void updateProjectPeriod() {
        this.startDate = issues.stream()
                .map(Issue::getStartDate)
                .min(LocalDate::compareTo)
                .orElse(null);

        this.endDate = issues.stream()
                .map(Issue::getEndDate)
                .max(LocalDate::compareTo)
                .orElse(null);
    }

    public void updateTitle(String title) {
        if (StringUtils.isBlank(title)) {
            throw new IllegalArgumentException("제목은 필수입니다.");
        }
        this.title = title;
    }

    public void updateDescription(String description) {
        this.description = description;
    }

    public boolean isNotProjectManager(User manager) {
        return !this.manager.equals(manager);
    }
}
