package com.duvanlabrador.Survey.Mapper;

import com.duvanlabrador.Survey.DTO.SurveyDTO;
import com.duvanlabrador.Survey.Entity.SurveyEntity;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SurveyMapper {

    @Mappings(
            {
                    @Mapping(source = "surveyId", target = "surveyId"),
                    @Mapping(source = "question", target = "question"),
                    @Mapping(source = "optionEntity", target = "optionEntity")
            }
    )
    SurveyDTO surveyToGetDTO(SurveyEntity surveyEntity);
    @InheritInverseConfiguration
    SurveyEntity surveyToGetEntity(SurveyDTO surveyDTO);
}
