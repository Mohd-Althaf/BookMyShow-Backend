package com.example.BookMyShowBackend.ResponceDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponseDto {
    private int id;

    private String name;

    private Date releaseDate;

    private float duration;
}
