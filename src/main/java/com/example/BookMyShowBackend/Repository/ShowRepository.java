package com.example.BookMyShowBackend.Repository;

import com.example.BookMyShowBackend.Models.Shows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShowRepository extends JpaRepository<Shows,Integer> {
}
