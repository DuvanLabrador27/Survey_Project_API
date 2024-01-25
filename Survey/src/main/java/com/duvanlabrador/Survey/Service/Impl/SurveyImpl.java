package com.duvanlabrador.Survey.Service.Impl;

import com.duvanlabrador.Survey.DTO.SurveyDTO;
import com.duvanlabrador.Survey.Entity.SurveyEntity;
import com.duvanlabrador.Survey.Mapper.SurveyMapper;
import com.duvanlabrador.Survey.Repository.SurveyRepository;
import com.duvanlabrador.Survey.Service.Interface.SurveyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SurveyImpl implements SurveyService {

    private final SurveyRepository surveyRepository;
    private final SurveyMapper surveyMapper;

    public SurveyImpl(SurveyRepository surveyRepository, SurveyMapper surveyMapper){
        this.surveyRepository = surveyRepository;
        this.surveyMapper = surveyMapper;
    }

    @Override
    public List<SurveyDTO> listSurvey() {
        List<SurveyEntity> surveyEntity = this.surveyRepository.findAll();
        return surveyEntity.stream().map(survey -> this.surveyMapper.surveyToGetDTO(survey)).collect(Collectors.toList());
    }

    @Override
    public SurveyDTO getSurveyForId(Long surveyId) {
        return null;
    }

    @Override
    public SurveyDTO createSurvey(SurveyDTO surveyDTO) {
        return null;
    }

    @Override
    public SurveyDTO updateSurvey(Long surveyId, SurveyDTO surveyDTO) {
        return null;
    }

    @Override
    public Boolean deleteSurvey(Long surveyId) {
        return null;
    }
}
