package dev.itrust.assistantservice.model;

import dev.itrust.assistantservice.hack4law_assistant_service.model.TaskStatus;
import dev.itrust.assistantservice.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "case_s_task")
@Getter
@Setter
public class CaseTask extends BaseEntity {

    @ManyToOne(optional = false)
    private CaseStepDefinition caseStepDefinition;

    @ManyToOne(optional = false)
    private Case parentCase;

    private TaskStatus taskStatus;

    private LocalDate executionDate;
    private LocalDate reminderDate;
    private LocalTime reminderTime;
}
