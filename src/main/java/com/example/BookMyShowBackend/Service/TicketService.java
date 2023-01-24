package com.example.BookMyShowBackend.Service;


import com.example.BookMyShowBackend.Converters.TicketConverter;
import com.example.BookMyShowBackend.Models.*;
import com.example.BookMyShowBackend.Repository.ShowRepository;
import com.example.BookMyShowBackend.Repository.TheaterSeatRepository;
import com.example.BookMyShowBackend.Repository.TicketRepository;
import com.example.BookMyShowBackend.Repository.UserRepository;
import com.example.BookMyShowBackend.RequestDto.TicketRequestDto;
import com.example.BookMyShowBackend.ResponceDto.TicketResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TicketService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    TheaterSeatRepository theaterSeatRepository;
    @Autowired
    ShowRepository showRepository;

    @Autowired
    TicketRepository ticketRepository;

    public TicketResponseDto bookTicket(TicketRequestDto ticketRequestDto) throws Exception{

        List<String> requestSeats = ticketRequestDto.getRequestSeats();
        User user = userRepository.findById(ticketRequestDto.getUserId()).get();
        Shows shows = showRepository.findById(ticketRequestDto.getShowId()).get();

        List<ShowSeat> bookedSeats = new ArrayList<>();
        List<ShowSeat> showSeatList = shows.getListOfSeats();
        for(ShowSeat showSeat:showSeatList){
            if(!showSeat.isBooked() && requestSeats.contains(showSeat.getSeatNo())){
                bookedSeats.add(showSeat);
            }
        }

        if(bookedSeats.size()!=requestSeats.size())
            throw new Exception("Sorry! The requested seats are already booked. Please select another seats");
        Ticket ticket = new Ticket();
        int bill = 0;
for(ShowSeat showSeat:bookedSeats){
    showSeat.setBooked(true);
    showSeat.setShows(shows);
    showSeat.setBookedAt(new Date());
    showSeat.setTicket(ticket);
    TheaterSeat theaterSeat = theaterSeatRepository.findByseatNo(showSeat.getSeatNo());
    bill+=theaterSeat.getRate();
}



        ticket.setTimeStamp(new Date());
        ticket.setShow(shows);
        ticket.setUser(user);
        ticket.setBookedSeats(bookedSeats);
        ticket.setAmount(bill);
        ticket.setNumberOfSeats(bookedSeats.size());

        ticketRepository.save(ticket);
        TicketResponseDto ticketResponseDto = TicketConverter.convertEntiityToDto(ticket);
        ticketResponseDto.setSeatNumbers(requestSeats);
        ticketResponseDto.setTheaterName(shows.getTheater().getName());
        return ticketResponseDto;
    }
}
