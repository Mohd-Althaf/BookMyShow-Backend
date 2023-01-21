package com.example.BookMyShowBackend.ResponceDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReponseDto {

    private int id;

    private String name;

    private String email;

    private long phno;

    private String password;
}
