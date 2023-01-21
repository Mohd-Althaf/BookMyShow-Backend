package com.example.BookMyShowBackend.RequestDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowRequestDto {

    private Date showDate;

    private Date startTime;

    private Date endTime;

    private  String movieName;

    private int theaterId;
}
