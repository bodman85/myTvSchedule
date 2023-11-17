package com.example.myTvSchedule.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CAST_LIST", schema = "PUBLIC")
public class Cast {
    @Id
    private long id;

    @NotNull
    private String name;

    @NotNull
    private String imageUrl;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "castList")
    @JsonIgnore
    private List<TvShow> tvShowList;
}
