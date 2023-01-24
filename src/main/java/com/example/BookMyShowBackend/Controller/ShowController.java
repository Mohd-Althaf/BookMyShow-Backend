package com.example.BookMyShowBackend.Controller;


import com.example.BookMyShowBackend.RequestDto.ShowRequestDto;
import com.example.BookMyShowBackend.ResponceDto.ShowResponseDto;
import com.example.BookMyShowBackend.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/shows")
public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("/addShow")
    public ResponseEntity<String> addShow(@RequestBody ShowRequestDto showRequestDto){
        try {
            showService.addShow(showRequestDto);
            return new ResponseEntity<>("successfully added the show", HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>("Error while adding the show",HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getShowByMovieAndTheater")
    public ResponseEntity<List<ShowResponseDto>> getShows(@RequestParam Integer movie,Integer theater){
        return new ResponseEntity<>(showService.getShowByMovieAndTheater(movie,theater),HttpStatus.FOUND);
    }


}
