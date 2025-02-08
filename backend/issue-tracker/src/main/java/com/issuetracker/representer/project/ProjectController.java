package com.issuetracker.representer.project;

import com.issuetracker.application.project.usecase.*;
import com.issuetracker.core.project.domain.model.Project;
import com.issuetracker.representer.project.dto.request.CreateProjectRequest;
import com.issuetracker.representer.project.dto.request.DeleteProjectRequest;
import com.issuetracker.representer.project.dto.request.ModifyProjectRequest;
import com.issuetracker.representer.project.dto.response.ProjectDetailResponse;
import com.issuetracker.representer.project.dto.response.ProjectResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProjectController {

    private final CreateProjectUseCase createProjectUseCase;
    private final GetProjectsUseCase getProjectsUseCase;
    private final GetProjectByIdUseCase getProjectByIdUseCase;
    private final ModifyProjectUseCase modifyProjectUseCase;
    private final DeleteProjectUseCase deleteProjectUseCase;
    private final ProjectControllerMapper mapper;

    @PostMapping("/projects")
    public ResponseEntity<ProjectResponse> createProject(@RequestBody CreateProjectRequest request) {
        Project project = createProjectUseCase.execute(mapper.toCreateProjectCommand(request));
        return ResponseEntity.ok().body(mapper.toProjectResponse(project));
    }

    @GetMapping("/projects")
    public ResponseEntity<List<ProjectResponse>> fetchProjects() {
        List<Project> projects = getProjectsUseCase.execute();
        return ResponseEntity.ok().body(mapper.toProjectResponseList(projects));
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<ProjectDetailResponse> fetchProject(@PathVariable long id) {
        Project project = getProjectByIdUseCase.execute(id);
        return ResponseEntity.ok().body(mapper.toProjectDetailResponse(project));
    }

    @PatchMapping("/projects/{id}")
    public ResponseEntity<ProjectDetailResponse> modifyProject(@PathVariable long id,
                                                               @RequestBody ModifyProjectRequest request) {
        Project project = modifyProjectUseCase.execute(mapper.toModifyProjectCommand(id, request));
        return ResponseEntity.ok().body(mapper.toProjectDetailResponse(project));
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable long id,
                                                @RequestBody DeleteProjectRequest request) {
        deleteProjectUseCase.execute(mapper.toDeleteProjectCommand(id, request));
        return ResponseEntity.ok().body("deleted");
    }
}
