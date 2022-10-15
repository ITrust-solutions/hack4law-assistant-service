package dev.itrust.assistantservice.repository;

import dev.itrust.assistantservice.model.CaseDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseDefinitionRepository extends JpaRepository<CaseDefinition, Long> {

}
