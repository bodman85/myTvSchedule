package com.example.myTvSchedule.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EpisodeDto {
    private Long id;

    private Long tvShowId;

    private String name;

    private int season;

    private int number;

    private LocalDate airdate;

    private Boolean watched;

}
