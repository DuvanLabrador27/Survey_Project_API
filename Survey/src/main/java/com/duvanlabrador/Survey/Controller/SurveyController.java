package com.duvanlabrador.Survey.Controller;

import com.duvanlabrador.Survey.DTO.SurveyDTO;
import com.duvanlabrador.Survey.Service.Interface.SurveyService;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/listSurvey/{surveyId}")
    public ResponseEntity<?> listById(@PathVariable Long surveyId) {
        try{
            SurveyDTO surveyDTO = this.surveyService.getSurveyForId(surveyId);
            return new ResponseEntity<>(surveyDTO, HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> crateSurvey(@RequestBody SurveyDTO surveyDTO){
        try{
            SurveyDTO survey = this.surveyService.createSurvey(surveyDTO);
            return new ResponseEntity<>(survey,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{surveyId}")
    public ResponseEntity<?> updateSurvey(@PathVariable Long surveyId, @RequestBody SurveyDTO surveyDTO){
        try{
            SurveyDTO survey = this.surveyService.updateSurvey(surveyId, surveyDTO);
            return new ResponseEntity<>(survey,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/delete/{surveyId}")
    public ResponseEntity<?> deleteSurvey(@PathVariable Long surveyId){
        try {
            Boolean surveyDelete = this.surveyService.deleteSurvey(surveyId);
            if(surveyDelete){
                return new ResponseEntity<>("The survey has been delete correctly", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("The survey dosen't exist", HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
