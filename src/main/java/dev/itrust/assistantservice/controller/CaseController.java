package dev.itrust.assistantservice.controller;

import dev.itrust.assistantservice.hack4law_assistant_service.api.QueryCaseApi;
import dev.itrust.assistantservice.hack4law_assistant_service.model.CaseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CaseController implements QueryCaseApi {

    @Override
    public ResponseEntity<List<CaseDto>> findAllCases() {
        return ResponseEntity.ok(List.of(new CaseDto().id(1)));
    }
}
