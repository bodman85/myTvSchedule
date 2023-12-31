package com.example.myTvSchedule.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TvShowResponseDto {
    private long id;

    private String name;

    private String imageUrl;

    private boolean deleted;

    Collection<EpisodeDto> episodes;

    Collection<CastResponseDto> castList;
}
