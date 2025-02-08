package com.issuetracker.representer.label;

import com.issuetracker.application.label.data.command.CreateLabelCommand;
import com.issuetracker.application.label.data.command.DeleteLabelCommand;
import com.issuetracker.application.label.data.command.ModifyLabelCommand;
import com.issuetracker.core.label.domain.model.Label;
import com.issuetracker.representer.common.CommonControllerMapper;
import com.issuetracker.representer.label.dto.request.CreateLabelRequest;
import com.issuetracker.representer.label.dto.request.DeleteLabelRequest;
import com.issuetracker.representer.label.dto.request.ModifyLabelRequest;
import com.issuetracker.representer.label.dto.response.LabelResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LabelControllerMapper extends CommonControllerMapper {

    public CreateLabelCommand toCreateLabelCommand(CreateLabelRequest request) {
        return new CreateLabelCommand(request.name(), request.userId());
    }

    public List<LabelResponse> toLabelsResponse(List<Label> labels) {
        return labels.stream()
                .map(this::toLabelResponse)
                .collect(Collectors.toList());
    }

    public ModifyLabelCommand toModifyLabelCommand(Long id, ModifyLabelRequest request) {
        return new ModifyLabelCommand(id, request.name(), request.userId());
    }

    public DeleteLabelCommand toDeleteLabelCommand(Long id, DeleteLabelRequest request) {
        return new DeleteLabelCommand(id, request.userId());
    }
}
