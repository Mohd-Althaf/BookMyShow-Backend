package com.example.BookMyShowBackend.RequestDto;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class userRequestDto {
    private String name;

    @Column(nullable = false,unique = true)
    private String email;

    private long phno;

    private String password;
}
