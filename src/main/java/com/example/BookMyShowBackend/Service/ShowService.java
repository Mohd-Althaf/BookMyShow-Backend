package com.example.BookMyShowBackend.Service;


import com.example.BookMyShowBackend.Converters.ShowConverter;
import com.example.BookMyShowBackend.Models.*;
import com.example.BookMyShowBackend.Repository.MovieRepository;
import com.example.BookMyShowBackend.Repository.ShowRepository;
import com.example.BookMyShowBackend.Repository.ShowSeatRepository;
import com.example.BookMyShowBackend.Repository.TheaterRepository;
import com.example.BookMyShowBackend.RequestDto.ShowRequestDto;
import com.example.BookMyShowBackend.ResponceDto.ShowResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowRepository showRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;
    public void addShow(ShowRequestDto showRequestDto) throws Exception {

        try {

            Movie movie = movieRepository.findByName(showRequestDto.getMovieName());
            Theater theater = theaterRepository.getOne(showRequestDto.getTheaterId());
            Shows shows = ShowConverter.convertDtoToEntity(showRequestDto);
            shows.setMovie(movie);
            shows.setTheater(theater);

            movie.getListOfShows().add(shows);
            theater.getListOfShows().add(shows);

        List<ShowSeat> showSeatList = createShowSeats(theater.getListOfTheaterSeats());
        shows.setListOfSeats(showSeatList);

        for(ShowSeat showSeat:showSeatList){
            showSeat.setShows(shows);
        }

        movieRepository.save(movie);
        theaterRepository.save(theater);
        showRepository.save(shows);
        }
        catch (Exception e){
           throw  new Exception();
        }
    }

    public List<ShowSeat> createShowSeats(List<TheaterSeat> theaterSeatList){
        List<ShowSeat> showSeatList = new ArrayList<>();

        for(TheaterSeat theaterSeat:theaterSeatList){
            ShowSeat showSeat = ShowSeat.builder()
                    .seatNo(theaterSeat.getSeatNo())
                    .seatType(theaterSeat.getSeatType())
                    .build();
            showSeatList.add(showSeat);
        }
        showSeatRepository.saveAll(showSeatList);
        return showSeatList;

    }

    public List<ShowResponseDto> getShowByMovieAndTheater(Integer movie, Integer theater) {
        Movie movie1 = movieRepository.findById(movie).get();
        List<Shows> showsList = showRepository.findBymovie(movie1);

        List<Shows> resultshows = new ArrayList<>();
        for(Shows shows1:showsList){
            if(shows1.getTheater().getId()==theater)
                resultshows.add(shows1);
        }
        return ShowConverter.convertEntityListToDto(resultshows);
    }
}
