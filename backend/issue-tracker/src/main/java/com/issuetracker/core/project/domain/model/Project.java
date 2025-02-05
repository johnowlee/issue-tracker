package com.issuetracker.core.project.domain.model;

import com.issuetracker.core.project.domain.service.dto.CreateProjectInfo;
import com.issuetracker.core.user.domain.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
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
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Issue> issues = new HashSet<>();

    @Builder
    public Project(Long id, String title, String description, LocalDateTime startDateTime, LocalDateTime endDateTime, Set<Issue> issues) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
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

    protected void addIssue(Issue issue) {
        this.issues.add(issue);
    }

    public void updateProjectPeriod() {
        this.startDateTime = issues.stream()
                .map(Issue::getStartDateTime)
                .min(LocalDateTime::compareTo)
                .orElse(null);

        this.endDateTime = issues.stream()
                .map(Issue::getEndDateTime)
                .max(LocalDateTime::compareTo)
                .orElse(null);
    }
}
