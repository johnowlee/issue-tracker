package com.issuetracker.representer.project.controller;

import com.issuetracker.application.project.usecase.GetIssueByIdUseCase;
import com.issuetracker.core.project.domain.model.Issue;
import com.issuetracker.representer.project.dto.response.GetIssueResponse;
import com.issuetracker.representer.project.mapper.ProjectControllerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class IssueController {

    private final GetIssueByIdUseCase getIssueByIdUseCase;
    private final ProjectControllerMapper mapper;

    @GetMapping("/issues/{id}")
    public ResponseEntity<GetIssueResponse> getIssue(@PathVariable long id) {
        Issue issue = getIssueByIdUseCase.execute(id);
        return ResponseEntity.ok().body(mapper.toGetIssueResponse(issue));
    }
}
