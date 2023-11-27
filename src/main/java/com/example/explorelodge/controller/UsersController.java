package com.example.explorelodge.controller;

import com.example.explorelodge.model.LoginDto;
import com.example.explorelodge.model.LoginMesage;
import com.example.explorelodge.model.UserDto;
import com.example.explorelodge.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5173")
@RequestMapping("api/users")
public class UsersController {
    @Autowired
    private UserService userService;
    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserDto userDto)
    {
        String ID = userService.addUser(userDto);
        return ID;
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDTO)
    {
        LoginMesage loginResponse = userService.loginMesage(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}