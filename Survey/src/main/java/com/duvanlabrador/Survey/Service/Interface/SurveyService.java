package com.duvanlabrador.Survey.Service.Interface;

import com.duvanlabrador.Survey.DTO.SurveyDTO;

import java.util.List;

public interface SurveyService {
    public List<SurveyDTO> listSurvey();
    public SurveyDTO getSurveyForId(Long surveyId);
    public SurveyDTO createSurvey(SurveyDTO surveyDTO);
    public SurveyDTO updateSurvey(Long surveyId, SurveyDTO surveyDTO);
    public Boolean deleteSurvey(Long surveyId);
}
