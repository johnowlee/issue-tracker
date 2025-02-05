package com.issuetracker.representer.project.controller;

import com.issuetracker.application.project.usecase.CreateProjectUseCase;
import com.issuetracker.core.project.domain.model.Project;
import com.issuetracker.representer.project.dto.request.CreateProjectRequest;
import com.issuetracker.representer.project.dto.response.CreateProjectResponse;
import com.issuetracker.representer.project.mapper.ProjectControllerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProjectController {

    private final CreateProjectUseCase createProjectUseCase;
    private final ProjectControllerMapper mapper;

    @PostMapping("/projects")
    public ResponseEntity<CreateProjectResponse> createProject(@RequestBody CreateProjectRequest request) {
        Project response = createProjectUseCase.execute(mapper.toCreateProjectCommand(request));
        return ResponseEntity.ok().body(mapper.toCreateProjectResponse(response));
    }

}
