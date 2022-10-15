package dev.itrust.assistantservice.model;

import dev.itrust.assistantservice.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "note_s")
@Getter
@Setter
public class Note extends BaseEntity {

    private String comment;
}
