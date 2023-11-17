package com.example.myTvSchedule.mapper;

import com.example.myTvSchedule.model.TvShow;
import com.example.myTvSchedule.model.dto.TvShowRequestDto;
import com.example.myTvSchedule.model.dto.TvShowResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface TvShowMapper {
    TvShowMapper INSTANCE = Mappers.getMapper(TvShowMapper.class);

    @Mapping(target = "imageUrl", source = "image.original")
    @Mapping(target = "episodes", ignore = true)
    @Mapping(target = "deleted",ignore = true)
    TvShow toEntity(TvShowRequestDto dto);

    TvShowResponseDto toResponseDto(TvShow tvShow);

    List<TvShowResponseDto> toResponseDtos(List<TvShow> tvShows);
}
