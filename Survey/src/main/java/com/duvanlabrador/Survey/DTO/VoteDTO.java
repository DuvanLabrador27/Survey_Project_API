package com.duvanlabrador.Survey.DTO;

import com.duvanlabrador.Survey.Entity.OptionEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteDTO {
    private Long vote_id;
    private OptionEntity optionEntity;

}
