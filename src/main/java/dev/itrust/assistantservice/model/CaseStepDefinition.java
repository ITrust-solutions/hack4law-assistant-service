package dev.itrust.assistantservice.model;

import dev.itrust.assistantservice.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "case_s_step_definition")
@Getter
@Setter
public class CaseStepDefinition extends BaseEntity {

    @ManyToOne(optional = false)
    private CaseDefinition caseDefinition;

    private String key;
    private String name;
}
