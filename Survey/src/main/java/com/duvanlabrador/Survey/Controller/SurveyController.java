package com.duvanlabrador.Survey.Controller;

import com.duvanlabrador.Survey.DTO.SurveyDTO;
import com.duvanlabrador.Survey.Service.Interface.SurveyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SurveyController {
    private final SurveyService surveyService;
    public SurveyController(SurveyService surveyService){
        this.surveyService = surveyService;
    }

    @GetMapping("/listAll")
    public List<SurveyDTO> listAllSurvey() {
        return this.surveyService.listSurvey();
    }
}
