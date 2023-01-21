package com.example.BookMyShowBackend.Converters;

import com.example.BookMyShowBackend.Models.Shows;
import com.example.BookMyShowBackend.RequestDto.ShowRequestDto;

public class ShowConverter {
    public static Shows convertDtoToEntity(ShowRequestDto showRequestDto){
        Shows shows = Shows.builder()
                .showDate(showRequestDto.getShowDate())
                .startTime(showRequestDto.getStartTime())
                .endTime(showRequestDto.getEndTime()).build();
        return shows;
    }
}
