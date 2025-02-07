package com.issuetracker.core.issue.domain.service;

import com.issuetracker.core.issue.domain.model.Issue;
import com.issuetracker.core.issue.domain.model.IssueLabel;
import com.issuetracker.core.issue.domain.model.IssueUser;
import com.issuetracker.core.label.domain.model.Label;
import com.issuetracker.core.project.domain.model.Project;
import com.issuetracker.core.user.domain.model.User;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class IssueRelationManager {

    public void relateIssueUsers(Issue issue, Set<User> users) {
        users.forEach(user -> createAndSetAssignee(issue, user));
    }

    public void relateIssueLabels(Issue issue, Set<Label> labels) {
        labels.forEach(label -> createAndSetIssueLabel(issue, label));
    }

    public void relateIssueProject(Issue issue, Project project) {
        issue.setProject(project);
        project.updateProjectPeriod();
    }

    public void updateIssueLabelRelations(Issue issue, Set<Label> updatingLabels) {
        removeDeletingLabels(issue, updatingLabels);
        addInsertingLabels(issue, updatingLabels);
    }

    public void updateIssueUserRelations(Issue issue, Set<User> updatingAssignees) {
        removeDeletingAssignees(issue, updatingAssignees);
        addInsertingAssignees(issue, updatingAssignees);
    }

    private static void removeDeletingLabels(Issue issue, Set<Label> updatingLabels) {
        Set<Long> updatingLabelIds = convertToUpdatingLabelIdSet(updatingLabels);

        Iterator<IssueLabel> iterator = issue.getIssueLabels().iterator();
        while (iterator.hasNext()) {
            IssueLabel issueLabel = iterator.next();
            if (!updatingLabelIds.contains(issueLabel.getLabel().getId())) {
                iterator.remove();
                issueLabel.unsetIssue();
            }
        }
    }

    private static void addInsertingLabels(Issue issue, Set<Label> updatingLabels) {
        updatingLabels.stream()
                .filter(label -> !convertToIssueLabelMap(issue).containsKey(label.getId()))
                .forEach(label -> createAndSetIssueLabel(issue, label));
    }

    private static Map<Long, IssueLabel> convertToIssueLabelMap(Issue issue) {
        return issue.getIssueLabels().stream()
                .collect(Collectors.toMap(il -> il.getLabel().getId(), il -> il));
    }

    private static void createAndSetIssueLabel(Issue issue, Label label) {
        IssueLabel issueLabel = IssueLabel.create();
        issueLabel.setIssue(issue);
        issueLabel.setLabel(label);
    }

    private static Set<Long> convertToUpdatingLabelIdSet(Set<Label> updatingLabels) {
        return updatingLabels.stream()
                .map(Label::getId)
                .collect(Collectors.toSet());
    }

    private static void removeDeletingAssignees(Issue issue, Set<User> updatingAssignees) {
        Set<Long> updatingAssigneeIds = convertToUpdatingAssigneeIdSet(updatingAssignees);

        Iterator<IssueUser> iterator = issue.getAssignees().iterator();
        while (iterator.hasNext()) {
            IssueUser assignee = iterator.next();
            if (!updatingAssigneeIds.contains(assignee.getUser().getId())) {
                iterator.remove();
                assignee.unsetIssue();
            }
        }
    }

    private static Set<Long> convertToUpdatingAssigneeIdSet(Set<User> updatingAssignees) {
        return updatingAssignees.stream()
                .map(User::getId)
                .collect(Collectors.toSet());
    }

    private static void addInsertingAssignees(Issue issue, Set<User> updatingAssignees) {
        updatingAssignees.stream()
                .filter(user -> !convertToIssueUserMap(issue).containsKey(user.getId()))
                .forEach(user -> createAndSetAssignee(issue, user));
    }

    private static Map<Long, IssueUser> convertToIssueUserMap(Issue issue) {
        return issue.getAssignees().stream()
                .collect(Collectors.toMap(il -> il.getUser().getId(), il -> il));
    }

    private static void createAndSetAssignee(Issue issue, User user) {
        IssueUser issueUser = IssueUser.create();
        issueUser.setIssue(issue);
        issueUser.setUser(user);
    }
}
