package com.example.myTvSchedule.controller;

import com.example.myTvSchedule.model.Episode;
import com.example.myTvSchedule.model.TvShow;
import com.example.myTvSchedule.service.EpisodeService;
import com.example.myTvSchedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/api/v1"})
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    private final EpisodeService episodeService;

    @PostMapping("/show")
    public ResponseEntity<Object> add(String id) {
        try {
            TvShow tvShow = scheduleService.add(id);
            return new ResponseEntity<>(tvShow, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/show")
    public ResponseEntity<Object> delete(String id) {
        try {
            TvShow deletedTvShow = scheduleService.softDelete(id);
            return new ResponseEntity<>(deletedTvShow, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/show/all")
    public ResponseEntity<Object> getAll() {
        List<TvShow> tvShows = scheduleService.getAllTvShows();
        return new ResponseEntity<>(tvShows, HttpStatus.OK);
    }

    @PatchMapping("/episode/{id}")
    public ResponseEntity<Object> markWatched(@PathVariable long id) {
        try {
            Episode episode = episodeService.markWatched(id);
            return new ResponseEntity<>(episode, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
