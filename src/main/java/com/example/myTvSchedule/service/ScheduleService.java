package com.example.myTvSchedule.service;

import com.example.myTvSchedule.model.dto.TvShowResponseDto;

import java.util.List;

public interface ScheduleService {

    TvShowResponseDto add(String showId);

    TvShowResponseDto softDelete(String id);

    List<TvShowResponseDto> getAllTvShows();

    List<TvShowResponseDto> getFirstUnwatchedEpisode();
}
