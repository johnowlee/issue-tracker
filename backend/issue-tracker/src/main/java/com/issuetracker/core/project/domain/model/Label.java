package com.issuetracker.core.project.domain.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "label")
public class Label {

    @Id
    @Column(name = "label_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Builder
    private Label(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Label create(String name) {
        return builder().name(name).build();
    }
}
