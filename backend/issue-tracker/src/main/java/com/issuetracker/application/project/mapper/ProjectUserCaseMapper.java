package com.issuetracker.application.project.mapper;

import com.issuetracker.application.project.data.command.CreateProjectCommand;
import com.issuetracker.core.project.domain.service.dto.CreateProjectInfo;
import org.springframework.stereotype.Component;

@Component
public class ProjectUserCaseMapper {
    public CreateProjectInfo toCreateProjectInfo(CreateProjectCommand command) {
        return new CreateProjectInfo(command.managerId(), command.title(), command.description());
    }
}
