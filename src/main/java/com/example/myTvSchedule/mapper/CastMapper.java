package com.example.myTvSchedule.mapper;

import com.example.myTvSchedule.model.Cast;
import com.example.myTvSchedule.model.dto.CastRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CastMapper {

    CastMapper INSTANCE = Mappers.getMapper(CastMapper.class);

    @Mapping(target = "id", source = "person.id")
    @Mapping(target = "name", source = "person.name")
    @Mapping(target = "imageUrl", source = "person.image.original")
    @Mapping(target = "tvShowList", ignore=true)
    Cast toEntity(CastRequestDto dto);
}
