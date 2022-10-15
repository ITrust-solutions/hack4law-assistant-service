package dev.itrust.assistantservice.model;

import dev.itrust.assistantservice.hack4law_assistant_service.model.CaseStatus;
import dev.itrust.assistantservice.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "case_s")
@Getter
@Setter
public class Case extends BaseEntity {

    @ManyToOne(optional = false)
    private CaseDefinition caseDefinition;

    @ManyToOne
    private Case parent;

    private String caseNumber;
    private String description;
    private LocalDate receiptDate;
    private LocalDate deadlineDate;
    private String assignedUser;
    private String helpingUser;

    @Enumerated(EnumType.STRING)
    private CaseStatus caseStatus;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "parent_case_id")
    private List<Note> notesList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "parent_case_id")
    private List<File> filesList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "parent_case_id")
    private List<CaseTask> taskList = new ArrayList<>();

}
