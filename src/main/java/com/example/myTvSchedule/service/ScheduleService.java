package com.example.myTvSchedule.service;

import com.example.myTvSchedule.model.TvShow;

import java.util.List;

public interface ScheduleService {

    TvShow add(String showId);

    TvShow softDelete(String id);

    List<TvShow> getAllTvShows();
}
