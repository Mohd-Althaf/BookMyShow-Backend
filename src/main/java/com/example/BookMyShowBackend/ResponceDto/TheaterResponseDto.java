package com.example.BookMyShowBackend.ResponceDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheaterResponseDto {

    private int id;

    private String name;

    private String place;

    private int totalSeats;

}
