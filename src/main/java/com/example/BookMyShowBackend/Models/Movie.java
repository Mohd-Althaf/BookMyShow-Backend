package com.example.BookMyShowBackend.Models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="movie_table")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    private Date releaseDate;

    private float duration;

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private List<Shows> listOfShows;
}
