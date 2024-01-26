package com.duvanlabrador.Survey.Service.Impl;

import com.duvanlabrador.Survey.DTO.SurveyDTO;
import com.duvanlabrador.Survey.Entity.SurveyEntity;
import com.duvanlabrador.Survey.Mapper.SurveyMapper;
import com.duvanlabrador.Survey.Repository.SurveyRepository;
import com.duvanlabrador.Survey.Service.Interface.SurveyService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
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
        SurveyEntity surveyEntity = this.surveyRepository.findById(surveyId).get();
        SurveyDTO surveyDTO = this.surveyMapper.surveyToGetDTO(surveyEntity);
        return surveyDTO;
    }

    @Override
    public SurveyDTO createSurvey(SurveyDTO surveyDTO) {
        SurveyEntity surveyEntity = this.surveyMapper.surveyToGetEntity(surveyDTO);
        SurveyEntity saveSurvey = this.surveyRepository.save(surveyEntity);
        SurveyDTO surveydto = this.surveyMapper.surveyToGetDTO(saveSurvey);
        return surveydto;
    }

    @Override
    public SurveyDTO updateSurvey(Long surveyId, SurveyDTO surveyDTO) {
        SurveyEntity surveyEntity = this.surveyRepository.findById(surveyId).orElseThrow();
        surveyEntity.setQuestion(surveyDTO.getQuestion());
        SurveyEntity updateSurvey = this.surveyRepository.save(surveyEntity);
        SurveyDTO survey = this.surveyMapper.surveyToGetDTO(updateSurvey);
        return survey;
    }

    @Override
    public Boolean deleteSurvey(Long surveyId) {
        Optional<SurveyEntity> surveyEntity = this.surveyRepository.findById(surveyId);
        if (surveyEntity.isPresent()){
            surveyRepository.deleteById(surveyId);
            return true;
        }else {
            return false;
        }

    }
}
