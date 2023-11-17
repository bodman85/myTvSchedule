package com.example.myTvSchedule.mapper;

import com.example.myTvSchedule.model.Episode;
import com.example.myTvSchedule.model.dto.EpisodeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface EpisodeMapper {
    EpisodeMapper INSTANCE = Mappers.getMapper(EpisodeMapper.class);

    @Mapping(target = "watched", constant = "false")
    @Mapping(target = "tvShow", ignore = true)
    Episode toEntity(EpisodeDto dto);

}
