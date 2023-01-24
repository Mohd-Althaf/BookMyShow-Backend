package com.example.BookMyShowBackend.Repository;

import com.example.BookMyShowBackend.Models.Movie;
import com.example.BookMyShowBackend.Models.Shows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShowRepository extends JpaRepository<Shows,Integer> {
    List<Shows> findBymovie(Movie movie);
}
