package com.example.BookMyShowBackend.Service;


import com.example.BookMyShowBackend.Converters.MovieConverters;
import com.example.BookMyShowBackend.Models.Movie;
import com.example.BookMyShowBackend.Repository.MovieRepository;
import com.example.BookMyShowBackend.RequestDto.movieRequestDto;
import com.example.BookMyShowBackend.ResponceDto.MovieResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;
    public void addMovie(movieRequestDto movieRequestDto) {
        Movie movie = MovieConverters.convertDtoToEntity(movieRequestDto);
        movieRepository.save(movie);
    }

    public List<MovieResponseDto> getMoviesByName(String name) {
        List<Movie> movieList = movieRepository.findAllByName(name);
        return MovieConverters.convertEntityListToDto(movieList);
    }

    public MovieResponseDto getMovieByName(String name) {
        Movie movie = movieRepository.findByName(name);
        return MovieConverters.convertEntityToDto(movie);
    }

    public List<MovieResponseDto> getAllMovies() {
        List<Movie> movieList = movieRepository.findAll();
        return MovieConverters.convertEntityListToDto(movieList);
    }
}
