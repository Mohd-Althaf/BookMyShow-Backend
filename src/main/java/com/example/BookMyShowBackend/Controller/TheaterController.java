package com.example.BookMyShowBackend.Controller;


import com.example.BookMyShowBackend.RequestDto.theaterRequestDto;
import com.example.BookMyShowBackend.ResponceDto.TheaterResponseDto;
import com.example.BookMyShowBackend.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/theater")
public class TheaterController {


    @Autowired
    TheaterService theaterService;

    @PostMapping("/addTheater")
    public ResponseEntity<String> addTheater(@RequestBody theaterRequestDto theaterRequestDto){
        theaterService.addTheater(theaterRequestDto);
        return new ResponseEntity<>("successfully added the theater", HttpStatus.ACCEPTED);
    }

    @GetMapping("/getTheaterById")
    public ResponseEntity<TheaterResponseDto> getTheater(@RequestParam Integer id){
        TheaterResponseDto theaterResponseDto = theaterService.getTheaterById(id);
        if (theaterResponseDto!=null)
            return new ResponseEntity<>(theaterResponseDto,HttpStatus.FOUND);
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAllTheaters")
    public ResponseEntity<List<TheaterResponseDto>> getAllTheaters(){
        return new ResponseEntity<>(theaterService.getAllTheaters(),HttpStatus.FOUND);

    }

}
