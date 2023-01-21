package com.example.BookMyShowBackend.Controller;


import com.example.BookMyShowBackend.RequestDto.ShowRequestDto;
import com.example.BookMyShowBackend.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
