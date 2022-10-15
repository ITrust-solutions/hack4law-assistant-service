package dev.itrust.assistantservice.model;

import dev.itrust.assistantservice.hack4law_assistant_service.model.FileType;
import dev.itrust.assistantservice.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "file_s")
@Getter
@Setter
public class File extends BaseEntity {

    private String fileLink;
    private String fileDescription;

    @Enumerated(EnumType.STRING)
    private FileType fileType;

    @Lob
    private String fileData;
}
