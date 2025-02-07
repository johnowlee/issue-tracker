package com.issuetracker.representer.issue;

import com.issuetracker.application.issue.data.command.ChangeIssueStatusCommand;
import com.issuetracker.application.issue.data.command.CreateIssueCommand;
import com.issuetracker.application.issue.data.command.ModifyIssueAssigneesCommand;
import com.issuetracker.application.issue.data.command.ModifyIssueLabelsCommand;
import com.issuetracker.application.issue.usecase.*;
import com.issuetracker.core.issue.domain.model.Issue;
import com.issuetracker.representer.issue.dto.request.*;
import com.issuetracker.representer.issue.dto.response.IssueDetailResponse;
import com.issuetracker.representer.issue.dto.response.IssueDetailWithoutProjectResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class IssueController {

    private final GetIssueByIdUseCase getIssueByIdUseCase;
    private final CreateIssueUseCase createIssueUseCase;
    private final ModifyIssueUseCase modifyIssueUseCase;
    private final PatchIssueUseCase patchIssueUseCase;
    private final DeleteIssueUseCase deleteIssueUseCase;
    private final IssueControllerMapper mapper;

    @GetMapping("/issues/{id}")
    public ResponseEntity<IssueDetailResponse> fetchIssue(@PathVariable long id) {
        Issue issue = getIssueByIdUseCase.execute(id);
        return ResponseEntity.ok().body(mapper.toGetIssueResponse(issue));
    }

    @PostMapping("/issues")
    public ResponseEntity<IssueDetailWithoutProjectResponse> createIssue(@RequestBody CreateIssueRequest request) {
        CreateIssueCommand createIssueCommand = mapper.toCreateIssueCommand(request);
        Issue issue = createIssueUseCase.execute(createIssueCommand);
        return  ResponseEntity.ok().body(mapper.toIssueDetailWithoutProjectResponse(issue));
    }

    @DeleteMapping("/issues/{id}")
    public ResponseEntity<String> deleteIssue(@PathVariable long id) {
        deleteIssueUseCase.execute(id);
        return ResponseEntity.ok().body("deleted");
    }

    @PatchMapping("/issues/{id}")
    public ResponseEntity<IssueDetailWithoutProjectResponse> modifyIssue(@PathVariable long id,
                                                                         @RequestBody ModifyIssueRequest request) {
        Issue issue = modifyIssueUseCase.execute(mapper.toModifyIssueCommand(id, request));
        return ResponseEntity.ok().body(mapper.toIssueDetailWithoutProjectResponse(issue));
    }

    @PatchMapping("/issues/{id}/status")
    public ResponseEntity<IssueDetailWithoutProjectResponse> changeStatus(@PathVariable long id,
                                               @RequestBody ChangeIssueStatusRequest request) {
        Issue issue = patchIssueUseCase.execute(new ChangeIssueStatusCommand(id, request.status()));
        return ResponseEntity.ok().body(mapper.toIssueDetailWithoutProjectResponse(issue));
    }

    @PatchMapping("/issues/{id}/labels")
    public ResponseEntity<IssueDetailWithoutProjectResponse> modifyLabels(@PathVariable long id,
                                               @RequestBody ModifyIssueLabelsRequest request) {
        Issue issue = patchIssueUseCase.execute(new ModifyIssueLabelsCommand(id, request.labelIds()));
        return ResponseEntity.ok().body(mapper.toIssueDetailWithoutProjectResponse(issue));
    }

    @PatchMapping("/issues/{id}/assignees")
    public ResponseEntity<IssueDetailWithoutProjectResponse> changeAssignees(@PathVariable long id,
                                               @RequestBody ModifyIssueAssigneesRequest request) {
        Issue issue = patchIssueUseCase.execute(new ModifyIssueAssigneesCommand(id, request.assigneeIds()));
        return ResponseEntity.ok().body(mapper.toIssueDetailWithoutProjectResponse(issue));
    }
}
