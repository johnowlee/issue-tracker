package com.issuetracker.representer.project.controller;

import com.issuetracker.application.project.data.command.CreateIssueCommand;
import com.issuetracker.application.project.usecase.CreateIssueUseCase;
import com.issuetracker.application.project.usecase.CreateProjectUseCase;
import com.issuetracker.application.project.usecase.GetProjectByIdUseCase;
import com.issuetracker.core.project.domain.model.Issue;
import com.issuetracker.core.project.domain.model.Project;
import com.issuetracker.representer.project.dto.request.CreateIssueRequest;
import com.issuetracker.representer.project.dto.request.CreateProjectRequest;
import com.issuetracker.representer.project.dto.response.CreateIssueResponse;
import com.issuetracker.representer.project.dto.response.CreateProjectResponse;
import com.issuetracker.representer.project.dto.response.GetProjectResponse;
import com.issuetracker.representer.project.mapper.ProjectControllerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProjectController {

    private final CreateProjectUseCase createProjectUseCase;
    private final GetProjectByIdUseCase getProjectByIdUseCase;
    private final CreateIssueUseCase createIssueUseCase;
    private final ProjectControllerMapper mapper;

    @PostMapping("/projects")
    public ResponseEntity<CreateProjectResponse> createProject(@RequestBody CreateProjectRequest request) {
        Project response = createProjectUseCase.execute(mapper.toCreateProjectCommand(request));
        return ResponseEntity.ok().body(mapper.toCreateProjectResponse(response));
    }

    @GetMapping("/projects/{projectId}")
    public ResponseEntity<GetProjectResponse> fetchProject(@PathVariable long projectId) {
        Project project = getProjectByIdUseCase.execute(projectId);
        return ResponseEntity.ok().body(mapper.toGetProjectResponse(project));
    }

    @PostMapping("/projects/{projectId}/issues")
    public ResponseEntity<CreateIssueResponse> addIssue(@PathVariable long projectId,
                                                        @RequestBody CreateIssueRequest request) {
        CreateIssueCommand createIssueCommand = mapper.toCreateIssueCommand(request, projectId);
        Issue issue = createIssueUseCase.execute(createIssueCommand);
        return  ResponseEntity.ok().body(mapper.toCreateIssueResponse(issue));
    }

}
