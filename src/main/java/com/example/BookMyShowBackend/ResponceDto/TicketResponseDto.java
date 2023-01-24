package com.example.BookMyShowBackend.ResponceDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketResponseDto {

    private int ticketId;

    private int amount;

    private int noOfSeatsBooked;

    private String theaterName;

    private String movieName;

    private List<String> seatNumbers;
}
