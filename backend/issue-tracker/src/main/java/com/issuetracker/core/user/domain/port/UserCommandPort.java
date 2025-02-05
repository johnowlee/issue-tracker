package com.issuetracker.core.user.domain.port;

import com.issuetracker.core.user.domain.model.User;

public interface UserCommandPort {
    User save(User user);
}
