package com.example.BookMyShowBackend.Repository;

import com.example.BookMyShowBackend.Models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheaterRepository extends JpaRepository<Theater,Integer> {
    List<Theater> findByplace(String city);
}
