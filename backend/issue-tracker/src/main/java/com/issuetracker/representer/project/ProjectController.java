package com.issuetracker.representer.project;

import com.issuetracker.application.project.usecase.CreateProjectUseCase;
import com.issuetracker.application.project.usecase.GetProjectByIdUseCase;
import com.issuetracker.core.project.domain.model.Project;
import com.issuetracker.representer.project.dto.request.CreateProjectRequest;
import com.issuetracker.representer.project.dto.response.CreateProjectResponse;
import com.issuetracker.representer.project.dto.response.GetProjectResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProjectController {

    private final CreateProjectUseCase createProjectUseCase;
    private final GetProjectByIdUseCase getProjectByIdUseCase;
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

}
