package com.issuetracker.representer.issue;

import com.issuetracker.application.issue.data.command.CreateIssueCommand;
import com.issuetracker.application.issue.usecase.CreateIssueUseCase;
import com.issuetracker.application.issue.usecase.GetIssueByIdUseCase;
import com.issuetracker.core.issue.domain.model.Issue;
import com.issuetracker.representer.issue.dto.request.CreateIssueRequest;
import com.issuetracker.representer.issue.dto.request.ModifyIssueRequest;
import com.issuetracker.representer.issue.dto.response.CreateIssueResponse;
import com.issuetracker.representer.issue.dto.response.GetIssueResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class IssueController {

    private final GetIssueByIdUseCase getIssueByIdUseCase;
    private final CreateIssueUseCase createIssueUseCase;
    private final IssueControllerMapper mapper;

    @GetMapping("/issues/{id}")
    public ResponseEntity<GetIssueResponse> fetchIssue(@PathVariable long id) {
        Issue issue = getIssueByIdUseCase.execute(id);
        return ResponseEntity.ok().body(mapper.toGetIssueResponse(issue));
    }

    @PostMapping("/issues")
    public ResponseEntity<CreateIssueResponse> createIssue(@RequestBody CreateIssueRequest request) {
        CreateIssueCommand createIssueCommand = mapper.toCreateIssueCommand(request);
        Issue issue = createIssueUseCase.execute(createIssueCommand);
        return  ResponseEntity.ok().body(mapper.toCreateIssueResponse(issue));
    }

    @PatchMapping("/issues/{id}")
    public ResponseEntity<GetIssueResponse> modifyIssue(@PathVariable long id,
                                                        @RequestBody ModifyIssueRequest request) {
        Issue issue = getIssueByIdUseCase.execute(id);
        return ResponseEntity.ok().body(mapper.toGetIssueResponse(issue));
    }

    @PatchMapping("/issues/{id}/status")
    public ResponseEntity<String> changeStatus(@PathVariable long id,
                                               @RequestBody ModifyIssueRequest request) {
        return null;
    }

    @PatchMapping("/issues/{id}/labels")
    public ResponseEntity<String> changeLabels(@PathVariable long id,
                                               @RequestBody ModifyIssueRequest request) {
        return null;
    }

    @PatchMapping("/issues/{id}/assignees")
    public ResponseEntity<String> changeAssignees(@PathVariable long id,
                                               @RequestBody ModifyIssueRequest request) {
        return null;
    }
}
