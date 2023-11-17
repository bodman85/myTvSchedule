package com.example.myTvSchedule.service;

import com.example.myTvSchedule.model.TvShow;
import com.example.myTvSchedule.model.dto.TvShowDto;

import java.util.List;

public interface ScheduleService {

    TvShowDto add(String showId);

    TvShow softDelete(String id);

    List<TvShow> getAllTvShows();
}
