package com.example.BookMyShowBackend.RequestDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequestDto {

    private int userId;

    private int showId;

    private List<String> requestSeats;

}
