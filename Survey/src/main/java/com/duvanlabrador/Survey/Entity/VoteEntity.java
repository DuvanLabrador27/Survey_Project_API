package com.duvanlabrador.Survey.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "vote")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vote_id;
    @ManyToOne(
            targetEntity = OptionEntity.class
    )
    @JoinColumn(name = "option_id")
    private OptionEntity optionEntity;

}
