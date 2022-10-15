package dev.itrust.assistantservice.mapper;

import dev.itrust.assistantservice.hack4law_assistant_service.model.CaseDefinitionDto;
import dev.itrust.assistantservice.hack4law_assistant_service.model.CaseStepDefinitionDto;
import dev.itrust.assistantservice.model.CaseDefinition;
import dev.itrust.assistantservice.model.CaseStepDefinition;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface CaseDefinitionMapper {

    CaseDefinitionMapper INSTANCE = Mappers.getMapper(CaseDefinitionMapper.class);

    default CaseDefinition toModel(CaseDefinitionDto caseDefinitionDto) {
        if ( caseDefinitionDto == null ) {
            return null;
        }

        CaseDefinition caseDefinition = new CaseDefinition();

        if ( caseDefinitionDto.getId() != null ) {
            caseDefinition.setId( caseDefinitionDto.getId().longValue() );
        }
        caseDefinition.setKey( caseDefinitionDto.getKey() );
        caseDefinition.setCaseType( caseDefinitionDto.getCaseType() );
        caseDefinition.setName( caseDefinitionDto.getName() );

        List<CaseStepDefinition> caseStepDefinitionList = new ArrayList<>();
        for(CaseStepDefinitionDto caseStepDefinitionDto : caseDefinitionDto.getCaseStepDefinitionDtoList()) {
            var stepDef = toModel(caseStepDefinitionDto);
            stepDef.setCaseDefinition(caseDefinition);
            caseStepDefinitionList.add(stepDef);
        }

        caseDefinition.setCaseStepDefinitionList(caseStepDefinitionList);

        return caseDefinition;
    }

    default CaseDefinitionDto toDto(CaseDefinition caseDefinition) {
        if ( caseDefinition == null ) {
            return null;
        }

        CaseDefinitionDto caseDefinitionDto = new CaseDefinitionDto();

        if ( caseDefinition.getId() != null ) {
            caseDefinitionDto.setId( caseDefinition.getId().intValue() );
        }
        caseDefinitionDto.setKey( caseDefinition.getKey() );
        caseDefinitionDto.setCaseType( caseDefinition.getCaseType() );
        caseDefinitionDto.setName( caseDefinition.getName() );

        List<CaseStepDefinitionDto> caseStepDefinitionDtoList = new ArrayList<>();
        for(CaseStepDefinition caseStepDefinition : caseDefinition.getCaseStepDefinitionList()) {
            var stepDef = toDto(caseStepDefinition);
            caseStepDefinitionDtoList.add(stepDef);
        }

        caseDefinitionDto.setCaseStepDefinitionDtoList(caseStepDefinitionDtoList);

        return caseDefinitionDto;
    }


    default CaseStepDefinition toModel(CaseStepDefinitionDto caseStepDefinitionDto) {
        if ( caseStepDefinitionDto == null ) {
            return null;
        }

        CaseStepDefinition caseStepDefinition = new CaseStepDefinition();

        if ( caseStepDefinitionDto.getId() != null ) {
            caseStepDefinition.setId( caseStepDefinitionDto.getId().longValue() );
        }
        caseStepDefinition.setKey( caseStepDefinitionDto.getKey() );
        caseStepDefinition.setName( caseStepDefinitionDto.getName() );

        return caseStepDefinition;
    }

    default CaseStepDefinitionDto toDto(CaseStepDefinition caseStepDefinition) {
        if ( caseStepDefinition == null ) {
            return null;
        }

        CaseStepDefinitionDto caseStepDefinitionDto = new CaseStepDefinitionDto();

        if ( caseStepDefinition.getId() != null ) {
            caseStepDefinitionDto.setId( caseStepDefinition.getId().intValue() );
        }
        caseStepDefinitionDto.setKey( caseStepDefinition.getKey() );
        caseStepDefinitionDto.setName( caseStepDefinition.getName() );

        return caseStepDefinitionDto;
    }


}
