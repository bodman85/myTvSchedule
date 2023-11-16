package com.example.myTvSchedule.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Show {
    @Id
    private long id;
    private String name;
}
