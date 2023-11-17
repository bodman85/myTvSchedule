package com.example.myTvSchedule.service;

import com.example.myTvSchedule.exception.EntityNotFoundException;
import com.example.myTvSchedule.mapper.EpisodeMapper;
import com.example.myTvSchedule.mapper.TvShowMapper;
import com.example.myTvSchedule.model.Episode;
import com.example.myTvSchedule.model.TvShow;
import com.example.myTvSchedule.model.dto.EpisodeDto;
import com.example.myTvSchedule.model.dto.TvShowDto;
import com.example.myTvSchedule.repository.EpisodeRepository;
import com.example.myTvSchedule.repository.TvShowRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private WebClient webClient;

    private final TvShowRepository tvShowRepository;

    private final EpisodeRepository episodeRepository;

    @Override
    @Transactional
    public TvShow add(String id) {
        TvShowDto tvShowDto = webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/shows/{id}").build(id))
                .retrieve()
                .bodyToMono(TvShowDto.class)
                .block();
        TvShow tvShow = TvShowMapper.INSTANCE.toEntity(tvShowDto);
        tvShow.setDeleted(false);

        EpisodeDto[] episodeDtos = webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/shows/{id}/episodes").build(id))
                .retrieve()
                .bodyToMono(EpisodeDto[].class)
                .block();

        List<Episode> episodes = Arrays.stream(episodeDtos)
                .map(dto -> {
                    dto.setWatched(false);
                    return dto;
                })
                .map(EpisodeMapper.INSTANCE::toEntity)
                .collect(Collectors.toList());
        tvShow.setEpisodes(episodes);

        tvShowRepository.save(tvShow);
        return tvShow;
    }

    @Override
    @Transactional
    public TvShow softDelete(String id) {
        TvShow tvShow = tvShowRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new EntityNotFoundException("Cannot find tv-show by id: " + id));
        tvShow.setDeleted(true);
        tvShowRepository.save(tvShow);
        return tvShow;
    }

    @Override
    public List<TvShow> getAllTvShows() {
        return tvShowRepository.findAllByDeleted(false);
    }
}
