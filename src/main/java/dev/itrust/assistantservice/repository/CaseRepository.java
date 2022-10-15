package dev.itrust.assistantservice.repository;

import dev.itrust.assistantservice.model.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseRepository extends JpaRepository<Case, Long> {

}
