package com.example.myTvSchedule.service;

import com.example.myTvSchedule.mapper.ShowMapper;
import com.example.myTvSchedule.model.Show;
import com.example.myTvSchedule.model.dto.ShowDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    WebClient webClient;

    @Override
    public ShowDto add(String id) {
        Show show = webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/shows/{id}").build(id))
                .retrieve()
                .bodyToMono(Show.class)
                .block();
        return ShowMapper.INSTANCE.toDto(show);
    }
}
