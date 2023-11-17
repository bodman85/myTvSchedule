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
    public Show add(String id) {
        ShowDto dto = webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/shows/{id}").build(id))
                .retrieve()
                .bodyToMono(ShowDto.class)
                .block();
        return ShowMapper.INSTANCE.toEntity(dto);
    }
}
