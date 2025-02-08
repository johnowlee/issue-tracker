package com.issuetracker.application.project.mapper;

import com.issuetracker.application.project.data.command.CreateProjectCommand;
import com.issuetracker.application.project.data.command.DeleteProjectCommand;
import com.issuetracker.application.project.data.command.ModifyProjectCommand;
import com.issuetracker.core.project.domain.service.dto.CreateProjectInfo;
import com.issuetracker.core.project.domain.service.dto.DeleteProjectInfo;
import com.issuetracker.core.project.domain.service.dto.ModifyProjectInfo;
import org.springframework.stereotype.Component;

@Component
public class ProjectUseCaseMapper {
    
    public CreateProjectInfo toCreateProjectInfo(CreateProjectCommand command) {
        return new CreateProjectInfo(command.managerId(), command.title(), command.description());
    }

    public ModifyProjectInfo toModifyProjectInfo(ModifyProjectCommand command) {
        return new ModifyProjectInfo(command.projectId(), command.userId(), command.title(), command.description());
    }

    public DeleteProjectInfo toDeleteProjectInfo(DeleteProjectCommand command) {
        return new DeleteProjectInfo(command.projectId(), command.userId());
    }
}
