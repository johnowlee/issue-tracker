package com.issuetracker.core.label.domain.model;

import com.issuetracker.core.issue.domain.model.IssueLabel;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

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

    @OneToMany(mappedBy = "label", cascade = CascadeType.ALL, orphanRemoval = true)
    List<IssueLabel> issues;

    @Builder
    private Label(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Label create(String name) {
        return builder().name(name).build();
    }

    public void changeName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Label label = (Label) object;
        return Objects.equals(id, label.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
