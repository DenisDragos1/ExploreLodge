package com.example.explorelodge.security;

import com.example.explorelodge.model.LoginDto;
import com.example.explorelodge.model.LoginMesage;
import com.example.explorelodge.model.UserDto;

public interface UserService {
    String addUser(UserDto userDto);

    LoginMesage loginMesage(LoginDto loginDto);
}
