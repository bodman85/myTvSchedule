package com.example.myTvSchedule.repository;

import com.example.myTvSchedule.model.TvShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TvShowRepository extends JpaRepository<TvShow, Long> {

    List<TvShow> findAllByDeleted(boolean deleted);
}
