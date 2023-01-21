package com.example.BookMyShowBackend.RequestDto;


import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class movieRequestDto {

    private String name;

    private Date releaseDate;

    private float duration;

}
