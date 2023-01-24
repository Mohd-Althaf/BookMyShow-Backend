package com.example.BookMyShowBackend.Service;


import com.example.BookMyShowBackend.Converters.TheaterConverter;
import com.example.BookMyShowBackend.Enums.seatType;
import com.example.BookMyShowBackend.Models.Theater;
import com.example.BookMyShowBackend.Models.TheaterSeat;
import com.example.BookMyShowBackend.Repository.TheaterRepository;
import com.example.BookMyShowBackend.Repository.TheaterSeatRepository;
import com.example.BookMyShowBackend.RequestDto.theaterRequestDto;
import com.example.BookMyShowBackend.ResponceDto.TheaterResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {
    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    TheaterSeatRepository theaterSeatRepository;
    public void addTheater(theaterRequestDto theaterRequestDto) {
        Theater theater = TheaterConverter.convertDtoToEntity(theaterRequestDto);
        List<TheaterSeat> theaterSeatlist = createTheaterSeats(theater);
        theater.setListOfTheaterSeats(theaterSeatlist);
        for(TheaterSeat theaterSeat:theaterSeatlist)
            theaterSeat.setTheater(theater);

        theaterRepository.save(theater);

    }

    public List<TheaterSeat> createTheaterSeats(Theater theater){
        List<TheaterSeat> theaterSeatList = new ArrayList<>();

        int division = theater.getTotalSeats()/3;
        for(int i=1;i<=division;i++){
            TheaterSeat theaterSeat = new TheaterSeat(150,i+"G",seatType.GOLD);
            theaterSeatList.add(theaterSeat);
        }
        for(int i=1;i<=division;i++){
            TheaterSeat theaterSeat = new TheaterSeat(100,i+"S",seatType.SILVER);
            theaterSeatList.add(theaterSeat);
        }
        for(int i=1;i<=division;i++){
            TheaterSeat theaterSeat = new TheaterSeat(200,i+"P",seatType.PREMIUM);
            theaterSeatList.add(theaterSeat);
        }

        for(int i=1;i<=theater.getTotalSeats()%3;i++){
            TheaterSeat theaterSeat = new TheaterSeat(150,i+"G",seatType.GOLD);
            theaterSeatList.add(theaterSeat);
        }
        theaterSeatRepository.saveAll(theaterSeatList);
        return theaterSeatList;
    }

    public TheaterResponseDto getTheaterById(Integer id) {
        try{
            Theater theater = theaterRepository.getOne(id);
            return TheaterConverter.convertEntityToDto(theater);
        }
        catch (Exception e){
            return null;
        }




    }

    public List<TheaterResponseDto> getAllTheaters() {

        List<Theater> theaterList = theaterRepository.findAll();
        return TheaterConverter.convertEntityListToDtos(theaterList);

    }

    public List<TheaterResponseDto> getTheatersByCity(String city) {
        List<Theater> theaterList = theaterRepository.findByplace(city);
        return TheaterConverter.convertEntityListToDtos(theaterList);
    }

    public String deleteTheater(Integer id) {
        try{
            Theater theater = theaterRepository.findById(id).get();
            if(theater==null) throw new Exception();
            theaterRepository.delete(theater);
            return "successfully deleted the theater by theater id "+theater.getId();
        }
        catch (Exception e){
            return "Given theaterId "+id+" is invalid";
        }
    }
}
