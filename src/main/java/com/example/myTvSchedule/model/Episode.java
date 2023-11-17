package com.example.myTvSchedule.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="EPISODES", schema = "PUBLIC")
public class Episode {
    @Id
    private long id;

    @NotNull
    private String name;

    @NotNull
    private int season;

    @NotNull
    private int number;

    @NotNull
    private LocalDate airdate;

    private boolean watched;

    @ManyToOne
    @JoinColumn(name="tv_show_id", insertable=false, updatable=false)
    private TvShow tvShow;
}
