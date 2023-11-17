package com.example.myTvSchedule.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name="TV_SHOWS", schema = "PUBLIC")
public class Show {
    @Id
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String imageUrl;
}
