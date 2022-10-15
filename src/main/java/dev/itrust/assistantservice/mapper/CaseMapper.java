package dev.itrust.assistantservice.mapper;

import dev.itrust.assistantservice.hack4law_assistant_service.model.*;
import dev.itrust.assistantservice.model.Case;
import dev.itrust.assistantservice.model.CaseTask;
import dev.itrust.assistantservice.model.File;
import dev.itrust.assistantservice.model.Note;
import org.apache.commons.lang3.ArrayUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mapper
public interface CaseMapper {
    CaseMapper INSTANCE = Mappers.getMapper(CaseMapper.class);

    default Case toModel(CaseDto caseDto) {
        if ( caseDto == null ) {
            return null;
        }

        Case case1 = new Case();

        if ( caseDto.getId() != null ) {
            case1.setId( caseDto.getId().longValue() );
        }
        case1.setCaseNumber( caseDto.getCaseNumber() );
        case1.setDescription( caseDto.getDescription() );
        case1.setReceiptDate( caseDto.getReceiptDate() );
        case1.setDeadlineDate( caseDto.getDeadlineDate() );
        case1.setAssignedUser( caseDto.getAssignedUser() );
        case1.setHelpingUser( caseDto.getHelpingUser() );
        case1.setCaseStatus( caseDto.getCaseStatus() );
        case1.setNotesList( noteDtoListToNoteList( caseDto.getNotesList() ) );
        case1.setFilesList( fileDtoListToFileList( caseDto.getFilesList() ) );

        return case1;
    }

    default CaseResponseDto toDto(Case aCase) {
        if ( aCase == null ) {
            return null;
        }

        CaseResponseDto caseDto = new CaseResponseDto();

        if ( aCase.getId() != null ) {
            caseDto.setId( aCase.getId().intValue() );
        }
        caseDto.setCaseNumber( aCase.getCaseNumber() );
        caseDto.setDescription( aCase.getDescription() );
        caseDto.setReceiptDate( aCase.getReceiptDate() );
        caseDto.setDeadlineDate( aCase.getDeadlineDate() );
        caseDto.setCaseStatus( aCase.getCaseStatus() );
        caseDto.setAssignedUser( aCase.getAssignedUser() );
        caseDto.setHelpingUser( aCase.getHelpingUser() );
        caseDto.setNotesList( noteListToNoteDtoList( aCase.getNotesList() ) );
        caseDto.setFilesList( fileListToFileDtoList( aCase.getFilesList() ) );
        caseDto.setKey(aCase.getCaseDefinition().getKey());
        caseDto.setCaseType(aCase.getCaseDefinition().getCaseType());
        caseDto.setName(aCase.getCaseDefinition().getName());

        List<CaseTaskResponseDto> caseTaskDtoList = new ArrayList<>();
        for(CaseTask caseTask : aCase.getTaskList()) {
            var caseTaskDto = new CaseTaskResponseDto();
            caseTaskDto.setId(caseTask.getId().intValue());
            caseTaskDto.setKey(caseTask.getCaseStepDefinition().getKey());
            caseTaskDto.setName(caseTask.getCaseStepDefinition().getName());
            caseTaskDto.setTaskStatus(caseTask.getTaskStatus());
            caseTaskDtoList.add(caseTaskDto);
        }
        caseDto.setCaseTaskDtoList(caseTaskDtoList);

        return caseDto;
    }

    default Note noteDtoToNote(NoteDto noteDto) {
        if ( noteDto == null ) {
            return null;
        }

        Note note = new Note();

        note.setComment( noteDto.getComment() );

        return note;
    }

    default List<Note> noteDtoListToNoteList(List<NoteDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Note> list1 = new ArrayList<Note>( list.size() );
        for ( NoteDto noteDto : list ) {
            list1.add( noteDtoToNote( noteDto ) );
        }

        return list1;
    }

    default File fileDtoToFile(FileDto fileDto) {
        if ( fileDto == null ) {
            return null;
        }

        File file = new File();

        file.setFileLink( fileDto.getFileLink() );
        file.setFileDescription( fileDto.getFileDescription() );
        file.setFileType( fileDto.getFileType() );
        file.setFileData( fileDto.getFileData( ));

        return file;
    }

    default List<File> fileDtoListToFileList(List<FileDto> list) {
        if ( list == null ) {
            return null;
        }

        List<File> list1 = new ArrayList<File>( list.size() );
        for ( FileDto fileDto : list ) {
            list1.add( fileDtoToFile( fileDto ) );
        }

        return list1;
    }

    default NoteDto noteToNoteDto(Note note) {
        if ( note == null ) {
            return null;
        }

        NoteDto noteDto = new NoteDto();

        noteDto.setComment( note.getComment() );

        return noteDto;
    }

    default List<NoteDto> noteListToNoteDtoList(List<Note> list) {
        if ( list == null ) {
            return null;
        }

        List<NoteDto> list1 = new ArrayList<NoteDto>( list.size() );
        for ( Note note : list ) {
            list1.add( noteToNoteDto( note ) );
        }

        return list1;
    }

    default FileDto fileToFileDto(File file) {
        if ( file == null ) {
            return null;
        }

        FileDto fileDto = new FileDto();

        fileDto.setFileLink( file.getFileLink() );
        fileDto.setFileDescription( file.getFileDescription() );
        fileDto.setFileData(file.getFileData() );
        fileDto.setFileType( file.getFileType() );

        return fileDto;
    }

    default List<FileDto> fileListToFileDtoList(List<File> list) {
        if ( list == null ) {
            return null;
        }

        List<FileDto> list1 = new ArrayList<FileDto>( list.size() );
        for ( File file : list ) {
            list1.add( fileToFileDto( file ) );
        }

        return list1;
    }
}
