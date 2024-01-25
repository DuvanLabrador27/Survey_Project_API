package com.duvanlabrador.Survey.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "option")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "option_id")
    private Long optionId;
    @Column(name = "option_value")
    private String optionValue;
    @ManyToOne(
            targetEntity = SurveyEntity.class
    )
    @JoinColumn(name = "survey_id")
    private SurveyEntity surveyEntity;
    @OneToMany(
            targetEntity = VoteEntity.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "optionEntity"
    )
    private Set<VoteEntity> voteEntity;

}
