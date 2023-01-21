package com.example.BookMyShowBackend.Models;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="shows_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shows {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date showDate;

    @Temporal(value = TemporalType.TIME)
    private Date startTime;

    @Temporal(value = TemporalType.TIME)
    private Date endTime;

    @OneToMany(mappedBy = "shows",cascade = CascadeType.ALL)
    private List<ShowSeat> listOfSeats;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<Ticket> listOfTickets;

    @ManyToOne
    @JoinColumn
    private Theater theater;

    @ManyToOne
    @JoinColumn
    private Movie movie;
}
