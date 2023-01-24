package com.example.BookMyShowBackend.Repository;

import com.example.BookMyShowBackend.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findAllByName(String name);

    User findByemail(String email);
}
