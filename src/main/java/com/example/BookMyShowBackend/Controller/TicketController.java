package com.example.BookMyShowBackend.Controller;


import com.example.BookMyShowBackend.RequestDto.TicketRequestDto;
import com.example.BookMyShowBackend.ResponceDto.TicketResponseDto;
import com.example.BookMyShowBackend.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/bookTicket")
    public ResponseEntity<TicketResponseDto> bookTicket(@RequestBody TicketRequestDto ticketRequestDto) {
        try {
            TicketResponseDto ticketResponseDto = ticketService.bookTicket(ticketRequestDto);
            return new ResponseEntity<>(ticketResponseDto, HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteTicket(@RequestParam("id")Integer id){
       String res = ticketService.deleteTicket(id);
       return new ResponseEntity<>(res,HttpStatus.OK);
    }

}
