package com.example.demo.Services;

import com.example.demo.Entities.User;
import com.example.demo.dto.UserDto;

import java.util.List;

public interface UserService {

    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();

}
