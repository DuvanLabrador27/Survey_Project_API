package com.duvanlabrador.Survey.DTO;

import com.duvanlabrador.Survey.Entity.OptionEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyDTO {
    private Long surveyId;
    private String question;
    private Set<OptionEntity> optionEntity;
}
