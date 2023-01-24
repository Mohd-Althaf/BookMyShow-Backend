package com.example.BookMyShowBackend.Converters;

import com.example.BookMyShowBackend.Models.User;
import com.example.BookMyShowBackend.RequestDto.userRequestDto;
import com.example.BookMyShowBackend.ResponceDto.UserReponseDto;

import java.util.ArrayList;
import java.util.List;

public class UserConverter {

    public static User convertDtoToEntity(userRequestDto userdto){
        User user = User.builder().email(userdto.getEmail())
                .phno(userdto.getPhno())
                .password(userdto.getPassword())
                .name(userdto.getName()).build();
        return user;
    }

    public static UserReponseDto convertEntityToDto(User user){
        UserReponseDto userdto = UserReponseDto.builder().email(user.getEmail())
                .phno(user.getPhno())
                .password(user.getPassword())
                .name(user.getName())
                .id(user.getId()).build();
        return userdto;
    }

    public static List<UserReponseDto> convertEntityListToDto(List<User> userList) {
        List<UserReponseDto> list = new ArrayList<>();
        for(User user:userList){
            UserReponseDto userReponseDto = UserConverter.convertEntityToDto(user);
            list.add(userReponseDto);
        }
        return list;
    }
}
