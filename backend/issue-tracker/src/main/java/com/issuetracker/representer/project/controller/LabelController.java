package com.issuetracker.representer.project.controller;

import com.issuetracker.application.project.usecase.CreateLabelUseCase;
import com.issuetracker.application.project.usecase.GetLabelsUseCase;
import com.issuetracker.core.project.domain.model.Label;
import com.issuetracker.representer.project.dto.request.CreateLabelRequest;
import com.issuetracker.representer.project.dto.response.LabelResponse;
import com.issuetracker.representer.project.mapper.ProjectControllerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LabelController {

    private final CreateLabelUseCase createLabelUseCase;
    private final GetLabelsUseCase getLabelsUseCase;
    private final ProjectControllerMapper mapper;

    @PostMapping("/labels")
    public ResponseEntity<LabelResponse> getIssue(@RequestBody CreateLabelRequest request) {
        Label label = createLabelUseCase.execute(mapper.toCreateLabelCommand(request));
        return ResponseEntity.ok().body(mapper.toLabelResponse(label));
    }

    @GetMapping("/labels")
    public ResponseEntity<List<LabelResponse>> fetchLabels() {
        List<Label> labels = getLabelsUseCase.execute();
        return ResponseEntity.ok().body(mapper.toLabelsResponse(labels));
    }
}
