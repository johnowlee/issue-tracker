package com.issuetracker.application.user.usecase;

import com.issuetracker.application.user.data.command.ChangeUserRoleCommand;
import com.issuetracker.core.user.domain.model.User;
import com.issuetracker.core.user.domain.service.UserCommandService;
import com.issuetracker.core.user.domain.service.dto.ChangeUserRoleInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ChangeUserRoleUseCase {

    private final UserCommandService userCommandService;

    public User execute(ChangeUserRoleCommand command) {
        return userCommandService.changeRole(new ChangeUserRoleInfo(command.adminId(), command.userId(), command.role()));
    }
}
