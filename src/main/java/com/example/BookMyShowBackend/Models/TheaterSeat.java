package com.example.BookMyShowBackend.Models;


import javax.persistence.*;

import com.example.BookMyShowBackend.Enums.seatType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="theaterSeat_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TheaterSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private seatType seatType;

    private int rate;

    @ManyToOne
    @JoinColumn
    private Theater theater;

    public TheaterSeat( int rate,String seatNo, seatType seatType) {
        this.seatNo = seatNo;
        this.seatType = seatType;
        this.rate = rate;
    }
}
