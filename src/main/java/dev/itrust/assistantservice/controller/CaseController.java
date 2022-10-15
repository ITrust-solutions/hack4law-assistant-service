package dev.itrust.assistantservice.controller;

import dev.itrust.assistantservice.hack4law_assistant_service.api.CaseAttachmentsApi;
import dev.itrust.assistantservice.hack4law_assistant_service.api.CreateCaseApi;
import dev.itrust.assistantservice.hack4law_assistant_service.api.QueryCaseApi;
import dev.itrust.assistantservice.hack4law_assistant_service.model.CaseDefinitionDto;
import dev.itrust.assistantservice.hack4law_assistant_service.model.CaseDto;
import dev.itrust.assistantservice.hack4law_assistant_service.model.CaseResponseDto;
import dev.itrust.assistantservice.service.CaseService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CaseController implements QueryCaseApi, CreateCaseApi, CaseAttachmentsApi {

    private final CaseService caseService;

    @Override
    public ResponseEntity<CaseResponseDto> createCase(CaseDto caseDto) {
        return ResponseEntity.ok(caseService.createCase(caseDto));
    }

    @Override
    public ResponseEntity<CaseDefinitionDto> createCaseDefinition(CaseDefinitionDto caseDefinitionDto) {
        return ResponseEntity.ok(caseService.createCaseDefinition(caseDefinitionDto));
    }

    @Override
    public ResponseEntity<List<CaseDefinitionDto>> findAllCaseDefinitions() {
        return ResponseEntity.ok(caseService.findAllCaseDefinitions());
    }

    @Override
    public ResponseEntity<List<CaseResponseDto>> findAllCases() {
        return ResponseEntity.ok(caseService.findAllCases());
    }

    @Override
    public ResponseEntity<CaseResponseDto> findCaseById(Integer caseId) {
        return ResponseEntity.ok(caseService.findCaseById(caseId));
    }

    @Override
    public ResponseEntity<CaseResponseDto> updateCaseById(Integer caseId, CaseDto caseDto) {
        return ResponseEntity.ok(caseService.updateCaseById(caseId, caseDto));
    }

    @SneakyThrows
    @Override
    public ResponseEntity<Void> uploadNewAttachment(Integer caseId, String fileType, String fileDescription, String fileLink, String fileData) {
        caseService.uploadAttachment(caseId, fileData, fileType, fileDescription, fileLink);
        return ResponseEntity.ok().build();
    }
}
