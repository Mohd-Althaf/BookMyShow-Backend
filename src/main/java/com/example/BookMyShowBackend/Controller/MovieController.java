package com.example.BookMyShowBackend.Controller;


import com.example.BookMyShowBackend.RequestDto.movieRequestDto;
import com.example.BookMyShowBackend.ResponceDto.MovieResponseDto;
import com.example.BookMyShowBackend.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {


    @Autowired
    MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody movieRequestDto movieRequestDto){
        movieService.addMovie(movieRequestDto);
        return new ResponseEntity<>("successfully added the movie", HttpStatus.ACCEPTED);
    }

    @GetMapping("/getMoviesByName")
    public ResponseEntity<List<MovieResponseDto>> getMoviesByName(@RequestParam String name){
        List<MovieResponseDto> list = movieService.getMoviesByName(name);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/getByName")
    public ResponseEntity<MovieResponseDto> getMovieByName(@RequestParam String name){
        MovieResponseDto movieResponseDto = movieService.getMovieByName(name);
        return new ResponseEntity<>(movieResponseDto,HttpStatus.OK);
    }

    @GetMapping("/getAllMovies")
    public ResponseEntity<List<MovieResponseDto>> getAllMovies(){
        List<MovieResponseDto> list = movieService.getAllMovies();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

}
