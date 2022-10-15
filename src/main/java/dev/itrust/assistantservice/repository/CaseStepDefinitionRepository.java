package dev.itrust.assistantservice.repository;

import dev.itrust.assistantservice.model.CaseStepDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseStepDefinitionRepository extends JpaRepository<CaseStepDefinition, Long> {
}
