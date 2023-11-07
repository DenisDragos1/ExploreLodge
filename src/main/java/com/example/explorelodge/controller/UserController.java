package com.example.explorelodge.controller;

import com.example.explorelodge.model.Users;
import com.example.explorelodge.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")
public class UserController {

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/user")
    Users newUser(@RequestBody Users newUser) {
        System.out.println("Nume: " + newUser.getNume());
        System.out.println("Prenume: " + newUser.getPrenume());
        System.out.println("Email: " + newUser.getEmail());

        // Criptare parola
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(newUser.getParola());
        newUser.setParola(hashedPassword);

        System.out.println("Parola criptată: " + hashedPassword);
        System.out.println("Tip Utilizator: " + newUser.getTip_utilizator());

        return usersRepository.save(newUser);
    }

    @GetMapping("/users")
    List<Users> getAllUsers() {
        return usersRepository.findAll();
    }
    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String parola) {
        Users user = usersRepository.findByEmail(email);

        if (user != null && user.getParola().equals(parola)) {
            // Autentificarea a reușit
            return "Autentificare reușită!";
        } else {
            // Autentificarea a eșuat
            return "Autentificare eșuată. Verificați email-ul și parola.";
        }
    }

}
