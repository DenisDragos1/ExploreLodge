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
    public ResponseEntity<String> saveUser(@RequestBody UserDto userDto) {
        try {
            String ID = userService.addUser(userDto);
            return ResponseEntity.ok("Userul a fost înregistrat cu succes. ID: " + ID);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("A apărut o eroare înregistrând utilizatorul: " + e.getMessage());
        }
    }

    @PostMapping(path = "/login")
    public ResponseEntity<LoginMesage> loginUser(@RequestBody LoginDto loginDTO) {
        LoginMesage loginResponse = userService.loginMesage(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}
