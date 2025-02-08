package com.issuetracker.application.issue.usecase;

import com.issuetracker.application.issue.data.command.DeleteIssueCommand;
import com.issuetracker.core.issue.domain.service.IssueCommandService;
import com.issuetracker.core.issue.domain.service.dto.DeleteIssueInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteIssueUseCase {

    private final IssueCommandService issueCommandService;

    public void execute(DeleteIssueCommand deleteIssueCommand) {
        issueCommandService.delete(new DeleteIssueInfo(deleteIssueCommand.issueId(), deleteIssueCommand.userId()));
    }
}
