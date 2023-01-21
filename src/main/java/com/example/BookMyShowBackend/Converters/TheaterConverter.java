package com.example.BookMyShowBackend.Converters;

import com.example.BookMyShowBackend.Models.Theater;
import com.example.BookMyShowBackend.RequestDto.theaterRequestDto;
import com.example.BookMyShowBackend.ResponceDto.TheaterResponseDto;

import java.util.ArrayList;
import java.util.List;

public class TheaterConverter {
    public static Theater convertDtoToEntity(theaterRequestDto theaterRequestDto){
        Theater theater = Theater.builder()
                .name(theaterRequestDto.getName())
                .place(theaterRequestDto.getPlace())
                .totalSeats(theaterRequestDto.getTotalSeats()).build();

        return theater;
    }

    public static TheaterResponseDto convertEntityToDto(Theater theater) {
        TheaterResponseDto theaterResponseDto = TheaterResponseDto.builder()
                .id(theater.getId())
                .name(theater.getName())
                .place(theater.getPlace())
                .totalSeats(theater.getTotalSeats()).build();
        return theaterResponseDto;
    }

    public static List<TheaterResponseDto> convertEntityListToDtos(List<Theater> theaterList) {
    List<TheaterResponseDto> theaterResponseDtos = new ArrayList<>();
    for(Theater theater:theaterList){
        TheaterResponseDto theaterResponseDto = TheaterResponseDto.builder()
                .id(theater.getId())
                .totalSeats(theater.getTotalSeats())
                .place(theater.getPlace())
                .name(theater.getName())
                .build();
        theaterResponseDtos.add(theaterResponseDto);
    }
    return theaterResponseDtos;
    }
}
