package com.example.BookMyShowBackend.Converters;

import com.example.BookMyShowBackend.Models.Ticket;
import com.example.BookMyShowBackend.ResponceDto.TicketResponseDto;

public class TicketConverter {
    public static TicketResponseDto convertEntiityToDto(Ticket ticket){
        TicketResponseDto ticketResponseDto = TicketResponseDto.builder()
                .ticketId(ticket.getId())
                .amount(ticket.getAmount())
                .movieName(ticket.getShow().getMovie().getName())
                .noOfSeatsBooked(ticket.getNumberOfSeats())
                .build();
        return ticketResponseDto;
    }
}
