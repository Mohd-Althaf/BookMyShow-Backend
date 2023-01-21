package com.example.BookMyShowBackend.Models;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "ticket_table")
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date timeStamp;

    private int NumberOfSeats;

    private int amount;

    @ManyToOne
    @JoinColumn
    private User user;

    @OneToMany(mappedBy = "ticket",cascade = CascadeType.ALL)
    private List<ShowSeat> bookedSeats;

    @ManyToOne
    @JoinColumn
    private Shows show;

}
