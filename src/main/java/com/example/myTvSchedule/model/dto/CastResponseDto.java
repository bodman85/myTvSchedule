package com.example.myTvSchedule.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CastResponseDto {
    private long id;

    private String name;

    private String imageUrl;
}
