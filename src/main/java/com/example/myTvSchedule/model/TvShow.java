package com.example.myTvSchedule.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TV_SHOWS", schema = "PUBLIC")
public class TvShow {
    @Id
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String imageUrl;

    @NotNull
    private boolean deleted;

    @OneToMany(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="tv_show_id")
    @ToString.Exclude
    private Collection<Episode> episodes;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "TV_SHOW_CAST",
            joinColumns = {@JoinColumn(name = "id")},
            inverseJoinColumns = {@JoinColumn(name = "tv_show_id")})
    private Collection<Cast> castList;
}
