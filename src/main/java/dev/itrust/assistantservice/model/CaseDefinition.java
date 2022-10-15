package dev.itrust.assistantservice.model;

import dev.itrust.assistantservice.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "case_s_definition")
@Getter
@Setter
public class CaseDefinition extends BaseEntity {

    private String key;
    private String caseType;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "case_definition_id")
    private List<CaseStepDefinition> caseStepDefinitionList = new ArrayList<>();
}
