package dev.itrust.assistantservice.service;

import dev.itrust.assistantservice.hack4law_assistant_service.model.CaseDefinitionDto;
import dev.itrust.assistantservice.hack4law_assistant_service.model.CaseDto;
import dev.itrust.assistantservice.hack4law_assistant_service.model.CaseResponseDto;
import dev.itrust.assistantservice.hack4law_assistant_service.model.CaseTaskDto;
import dev.itrust.assistantservice.mapper.CaseDefinitionMapper;
import dev.itrust.assistantservice.mapper.CaseMapper;
import dev.itrust.assistantservice.model.Case;
import dev.itrust.assistantservice.model.CaseDefinition;
import dev.itrust.assistantservice.model.CaseTask;
import dev.itrust.assistantservice.repository.CaseDefinitionRepository;
import dev.itrust.assistantservice.repository.CaseRepository;
import dev.itrust.assistantservice.repository.CaseStepDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CaseService {

    private final CaseDefinitionRepository caseDefinitionRepository;
    private final CaseRepository caseRepository;
    private final CaseStepDefinitionRepository caseStepDefinitionRepository;

    public CaseDefinitionDto createCaseDefinition(CaseDefinitionDto caseDefinitionDto) {
        return CaseDefinitionMapper.INSTANCE.toDto(caseDefinitionRepository.save(CaseDefinitionMapper.INSTANCE.toModel(caseDefinitionDto)));
    }

    public CaseResponseDto createCase(CaseDto caseDto) {
        var case1 = CaseMapper.INSTANCE.toModel(caseDto);
        var caseDef = caseDefinitionRepository.findById((long) caseDto.getCaseDefinitionId());
        if(caseDef == null) {
            throw new RuntimeException("Case Definition not found");
        }
        case1.setCaseDefinition(caseDef.get());

        List<CaseTask> caseTaskList = new ArrayList<>();
        for(CaseTaskDto caseTaskDto : caseDto.getCaseTaskDtoList()) {
            CaseTask caseTask = new CaseTask();
            caseTask.setParentCase(case1);
            var caseStepDefinition = caseStepDefinitionRepository.findById((long) caseTaskDto.getCaseStepDefinitionId());
            caseTask.setCaseStepDefinition(caseStepDefinition.get());
            caseTask.setTaskStatus(caseTaskDto.getTaskStatus());
            caseTaskList.add(caseTask);
        }
        case1.setTaskList(caseTaskList);

        caseRepository.save(case1);

        return CaseMapper.INSTANCE.toDto(case1);
    }

    public List<CaseDefinitionDto> findAllCaseDefinitions() {
        var caseDefList = caseDefinitionRepository.findAll();
        var dtoList = new ArrayList<CaseDefinitionDto>();
        for(CaseDefinition caseDefinition : caseDefList) {
            dtoList.add(CaseDefinitionMapper.INSTANCE.toDto(caseDefinition));
        }

        return dtoList;

    }

    public List<CaseResponseDto> findAllCases() {
        var caseList = caseRepository.findAll();
        var dtoList = new ArrayList<CaseResponseDto>();
        for(Case case1 : caseList) {
            dtoList.add(CaseMapper.INSTANCE.toDto(case1));
        }

        return dtoList;
    }

    public CaseResponseDto findCaseById(int id) {
        var case1 = caseRepository.findById(Long.valueOf(id));
        if(case1.isPresent()) {
            return CaseMapper.INSTANCE.toDto(case1.get());
        }

        throw new RuntimeException("No case id found");
    }

    public CaseResponseDto updateCaseById(int id, CaseDto caseDto) {
        var case1 = caseRepository.findById(Long.valueOf(id)).get();
        case1.setCaseStatus(caseDto.getCaseStatus());
        case1.setCaseNumber(caseDto.getCaseNumber());
        case1.setDescription(caseDto.getDescription());
        case1.setReceiptDate(caseDto.getReceiptDate());
        case1.setDeadlineDate(caseDto.getDeadlineDate());
        case1.setAssignedUser(caseDto.getAssignedUser());
        case1.setHelpingUser(caseDto.getHelpingUser());

        caseRepository.save(case1);

        return CaseMapper.INSTANCE.toDto(case1);
    }
}
