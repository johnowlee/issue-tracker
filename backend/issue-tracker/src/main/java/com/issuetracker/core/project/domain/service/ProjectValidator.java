package com.issuetracker.core.project.domain.service;

import com.issuetracker.core.project.domain.model.Project;
import com.issuetracker.core.user.domain.model.User;
import org.springframework.stereotype.Component;


@Component
public class ProjectValidator {

    public void validateManager(Project project, User user) {
        // TODO: 2025-02-08
        if (project.isNotProjectManager(user)) {
            throw new IllegalArgumentException("프로젝트 관리자가 아닙니다.");
        }
    }
}
