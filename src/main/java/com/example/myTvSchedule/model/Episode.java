package com.example.myTvSchedule.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="EPISODES", schema = "PUBLIC")
public class Episode {
    @Id
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private int season;

    @NotNull
    private int number;

    @NotNull
    private LocalDate airdate;

    private Boolean watched;

    @ManyToOne(fetch= FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="tv_show_id", referencedColumnName="id")
    @ToString.Exclude
    private TvShow tvShow;
}
