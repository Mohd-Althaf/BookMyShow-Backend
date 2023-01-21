package com.example.BookMyShowBackend.Converters;

import com.example.BookMyShowBackend.Models.Movie;
import com.example.BookMyShowBackend.RequestDto.movieRequestDto;
import com.example.BookMyShowBackend.ResponceDto.MovieResponseDto;

import java.util.ArrayList;
import java.util.List;

public class MovieConverters {
    public static Movie convertDtoToEntity(movieRequestDto movieRequestDto){
        Movie movie = Movie.builder().name(movieRequestDto.getName())
                .duration(movieRequestDto.getDuration())
                .releaseDate(movieRequestDto.getReleaseDate()).build();
        return movie;
    }

    public static MovieResponseDto convertEntityToDto(Movie movieRequestDto){
        MovieResponseDto movie = MovieResponseDto.builder().name(movieRequestDto.getName())
                .duration(movieRequestDto.getDuration())
                .releaseDate(movieRequestDto.getReleaseDate())
                .id(movieRequestDto.getId()).build();
        return movie;
    }

    public static List<MovieResponseDto> convertEntityListToDto(List<Movie> movieList) {

        List<MovieResponseDto> movieResponseDtoList = new ArrayList<>();
        for(Movie movie:movieList){
            MovieResponseDto movieResponseDto = MovieConverters.convertEntityToDto(movie);
            movieResponseDtoList.add(movieResponseDto);
        }
        return movieResponseDtoList;
    }
}
