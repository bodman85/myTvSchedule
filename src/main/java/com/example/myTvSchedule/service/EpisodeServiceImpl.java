package com.example.myTvSchedule.service;

import com.example.myTvSchedule.exception.EntityNotFoundException;
import com.example.myTvSchedule.model.Episode;
import com.example.myTvSchedule.repository.EpisodeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EpisodeServiceImpl implements EpisodeService{

    private final EpisodeRepository episodeRepository;
    @Override
    @Transactional
    public Episode markWatched(long id) {
        Episode episode = episodeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find episode by id: " + id));
        episode.setWatched(true);
        return episodeRepository.save(episode);
    }
}
