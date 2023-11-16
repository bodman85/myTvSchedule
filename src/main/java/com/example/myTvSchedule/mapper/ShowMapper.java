package com.example.myTvSchedule.mapper;

import com.example.myTvSchedule.model.Show;
import com.example.myTvSchedule.model.dto.ShowDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShowMapper {
    ShowMapper INSTANCE = Mappers.getMapper(ShowMapper.class);

    ShowDto toDto(Show entity);
}
