package com.issuetracker.application.issue.usecase;

import com.issuetracker.application.issue.data.command.ChangeIssueStatusCommand;
import com.issuetracker.application.issue.data.command.ModifyIssueAssigneesCommand;
import com.issuetracker.application.issue.data.command.ModifyIssueLabelsCommand;
import com.issuetracker.application.issue.mapper.IssueUseCaseMapper;
import com.issuetracker.core.issue.domain.model.Issue;
import com.issuetracker.core.issue.domain.service.IssueCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PatchIssueUseCase {

    private final IssueCommandService issueCommandService;
    private final IssueUseCaseMapper mapper;

    public <T> Issue execute(T command) {
        if (command instanceof ChangeIssueStatusCommand changeIssueStatusCommand) {
            return issueCommandService.changeStatus(mapper.toChangeIssueStatusInfo(changeIssueStatusCommand));
        }
        if (command instanceof ModifyIssueLabelsCommand modifyIssueLabelsCommand) {
            return issueCommandService.modifyLabels(mapper.toModifyIssueLabelsInfo(modifyIssueLabelsCommand));
        }
        return issueCommandService.modifyAssignees(mapper.toModifyIssueAssigneesInfo((ModifyIssueAssigneesCommand) command));
    }
}
