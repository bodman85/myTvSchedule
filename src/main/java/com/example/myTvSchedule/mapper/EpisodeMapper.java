package com.example.myTvSchedule.mapper;

import com.example.myTvSchedule.model.Episode;
import com.example.myTvSchedule.model.dto.EpisodeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EpisodeMapper {
    EpisodeMapper INSTANCE = Mappers.getMapper(EpisodeMapper.class);

    @Mapping(target = "tvShow.id", source = "tvShowId")
    Episode toEntity(EpisodeDto dto);

    List<Episode> toEntities(List<EpisodeDto> dtos);
}
