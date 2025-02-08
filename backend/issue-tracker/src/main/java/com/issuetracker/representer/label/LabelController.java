package com.issuetracker.representer.label;

import com.issuetracker.application.label.usecase.CreateLabelUseCase;
import com.issuetracker.application.label.usecase.DeleteLabelUseCase;
import com.issuetracker.application.label.usecase.GetLabelsUseCase;
import com.issuetracker.application.label.usecase.ModifyLabelUseCase;
import com.issuetracker.core.label.domain.model.Label;
import com.issuetracker.representer.label.dto.request.CreateLabelRequest;
import com.issuetracker.representer.label.dto.request.DeleteLabelRequest;
import com.issuetracker.representer.label.dto.request.ModifyLabelRequest;
import com.issuetracker.representer.label.dto.response.LabelResponse;
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
    private final ModifyLabelUseCase modifyLabelUseCase;
    private final DeleteLabelUseCase deleteLabelUseCase;
    private final LabelControllerMapper mapper;

    @PostMapping("/labels")
    public ResponseEntity<LabelResponse> createLabel(@RequestBody CreateLabelRequest request) {
        Label label = createLabelUseCase.execute(mapper.toCreateLabelCommand(request));
        return ResponseEntity.ok().body(mapper.toLabelResponse(label));
    }

    @GetMapping("/labels")
    public ResponseEntity<List<LabelResponse>> fetchLabels() {
        List<Label> labels = getLabelsUseCase.execute();
        return ResponseEntity.ok().body(mapper.toLabelsResponse(labels));
    }

    @PatchMapping("/labels/{id}")
    public ResponseEntity<LabelResponse> modifyLabel(@PathVariable Long id,
                                                     @RequestBody ModifyLabelRequest request) {
        Label label = modifyLabelUseCase.execute(mapper.toModifyLabelCommand(id, request));
        return ResponseEntity.ok().body(mapper.toLabelResponse(label));
    }

    @DeleteMapping("/labels/{id}")
    public ResponseEntity<String> deleteLabel(@PathVariable Long id,
                                              @RequestBody DeleteLabelRequest request) {
        deleteLabelUseCase.execute(mapper.toDeleteLabelCommand(id, request));
        return ResponseEntity.ok().body("deleted");
    }
}
