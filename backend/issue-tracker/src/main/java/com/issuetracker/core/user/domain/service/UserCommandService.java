package com.issuetracker.core.user.domain.service;

import com.issuetracker.core.user.domain.model.User;
import com.issuetracker.core.user.domain.port.UserCommandPort;
import com.issuetracker.core.user.domain.service.dto.ChangeUserRoleInfo;
import com.issuetracker.core.user.domain.service.dto.CreateUserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCommandService {

    private final UserCommandPort userCommandPort;
    private final UserQueryService userQueryService;

    public User createUser(CreateUserInfo createUserInfo) {
        if (userQueryService.isPresentByEmail(createUserInfo.email())) {
            throw new IllegalArgumentException("중복된 이메일이 존재합니다.");
        }
        return userCommandPort.save(User.from(createUserInfo));
    }

    public User changeRole(ChangeUserRoleInfo info) {
        User admin = userQueryService.getUserById(info.adminId());
        admin.validateAdminRole();

        User user = userQueryService.getUserById(info.userId());
        user.changeRole(info.role());
        return user;
    }
}