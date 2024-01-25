package com.duvanlabrador.Survey.DTO;

import com.duvanlabrador.Survey.Entity.SurveyEntity;
import com.duvanlabrador.Survey.Entity.VoteEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionDTO {
    private Long optionId;
    private String optionValue;
    private SurveyEntity surveyEntity;
    private Set<VoteEntity> voteEntity;
}
