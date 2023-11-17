package com.example.myTvSchedule.controller;

import com.example.myTvSchedule.model.Show;
import com.example.myTvSchedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/api/v1"})
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/show")
    public ResponseEntity<Object> add(String showId) {
        Show show = scheduleService.add(showId);
        return new ResponseEntity<>(show, HttpStatus.CREATED);
    }
}
