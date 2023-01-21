package com.example.BookMyShowBackend.Models;


import com.example.BookMyShowBackend.Enums.seatType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name="showseat_table")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private seatType seatType;

    private boolean isBooked;

    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    private Ticket ticket;

    @ManyToOne
    @JoinColumn
    private Shows shows;
}
