package com.example.BookMyShowBackend.Service;


import com.example.BookMyShowBackend.Converters.UserConverter;
import com.example.BookMyShowBackend.Models.User;
import com.example.BookMyShowBackend.Repository.UserRepository;
import com.example.BookMyShowBackend.RequestDto.userRequestDto;
import com.example.BookMyShowBackend.ResponceDto.UserReponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public void addUser(userRequestDto userDto) throws Exception{

        try{
            User user = UserConverter.convertDtoToEntity(userDto);
            userRepository.save(user);
        }
        catch (Exception e) {
            throw new Exception();
        }

    }

    public UserReponseDto getUserById(int id) throws Exception{
        try {
            User user = userRepository.getOne(id);
            if(user!=null)
            return UserConverter.convertEntityToDto(user);
            throw new Exception();
        }
        catch (Exception e){
            throw new Exception();
        }
    }

    public List<UserReponseDto> getUsersByName(String name) {
        List<User> userList = userRepository.findAllByName(name);
        return UserConverter.convertEntityListToDto(userList);
    }

    public List<UserReponseDto> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return UserConverter.convertEntityListToDto(userList);
    }
}
