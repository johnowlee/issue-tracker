package com.issuetracker.core.user.domain.model;

import com.issuetracker.core.user.domain.service.dto.CreateUserInfo;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String email;
    String password;

    @Enumerated(EnumType.STRING)
    UserRole role;

    @Builder
    private User(Long id, String name, String email, String password, UserRole role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public static User from(CreateUserInfo createUserInfo) {
        return builder()
                .name(createUserInfo.name())
                .email(createUserInfo.email())
                .password(createUserInfo.password())
                .role(UserRole.USER)
                .build();
    }
}
