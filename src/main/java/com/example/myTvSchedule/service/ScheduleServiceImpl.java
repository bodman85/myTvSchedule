package com.example.myTvSchedule.service;

import com.example.myTvSchedule.exception.EntityNotFoundException;
import com.example.myTvSchedule.mapper.EpisodeMapper;
import com.example.myTvSchedule.mapper.TvShowMapper;
import com.example.myTvSchedule.model.Episode;
import com.example.myTvSchedule.model.dto.EpisodeDto;
import com.example.myTvSchedule.model.dto.TvShowRequestDto;
import com.example.myTvSchedule.model.dto.TvShowResponseDto;
import com.example.myTvSchedule.repository.TvShowRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private WebClient webClient;

    private final TvShowRepository tvShowRepository;

    @Override
    @Transactional
    public TvShowResponseDto add(String id) {
        var tvShowRequestDto = webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/shows/{id}").build(id))
                .retrieve()
                .bodyToMono(TvShowRequestDto.class)
                .block();

        var episodeDtos = webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/shows/{id}/episodes").build(id))
                .retrieve()
                .bodyToMono(EpisodeDto[].class)
                .block();

        var tvShow = TvShowMapper.INSTANCE.toEntity(tvShowRequestDto);
        List<Episode> episodes = Arrays.stream(episodeDtos)
                .map(EpisodeMapper.INSTANCE::toEntity)
                .collect(Collectors.toList());

        tvShow.setEpisodes(episodes);
        tvShowRepository.save(tvShow);

        return TvShowMapper.INSTANCE.toResponseDto(tvShow);
    }

    @Override
    @Transactional
    public TvShowResponseDto softDelete(String id) {
        var tvShow = tvShowRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new EntityNotFoundException("Cannot find tv-show by id: " + id));
        tvShow.setDeleted(true);
        tvShowRepository.save(tvShow);
        return TvShowMapper.INSTANCE.toResponseDto(tvShow);
    }

    @Override
    public List<TvShowResponseDto> getAllTvShows() {
        var tvShows = tvShowRepository.findAllByDeleted(false);
        return TvShowMapper.INSTANCE.toResponseDtos(tvShows);
    }

    @Override
    public List<TvShowResponseDto> getFirstUnwatchedEpisode() {
        List<TvShowResponseDto> filteredTvShows = getAllTvShows();
        filteredTvShows.forEach(tvShow -> tvShow.setEpisodes(
                Collections.singletonList(tvShow.getEpisodes()
                        .stream()
                        .filter(episode -> !episode.isWatched())
                        .findFirst().orElseThrow(() -> new EntityNotFoundException("Cannot find unwatched episode")))));

        return filteredTvShows;
    }
}

