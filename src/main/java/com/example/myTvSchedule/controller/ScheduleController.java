package com.example.myTvSchedule.controller;

import com.example.myTvSchedule.model.TvShow;
import com.example.myTvSchedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = {"/api/v1/show"})
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<Object> add(String id) {
        try {
            TvShow tvShow = scheduleService.add(id);
            return new ResponseEntity<>(tvShow, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<Object> delete(String id) {
        try {
            TvShow deletedTvShow = scheduleService.softDelete(id);
            return new ResponseEntity<>(deletedTvShow, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAll() {
        List<TvShow> tvShows = scheduleService.getAllTvShows();
        return new ResponseEntity<>(tvShows, HttpStatus.OK);
    }
}
