package com.example.myTvSchedule.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TvShowDto {
    private long id;

    private String name;

    private ImageDto image;

    EpisodeDto[] episodes;
}
