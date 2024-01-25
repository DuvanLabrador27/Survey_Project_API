package com.duvanlabrador.Survey.Repository;

import com.duvanlabrador.Survey.Entity.SurveyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<SurveyEntity, Long> {
}
