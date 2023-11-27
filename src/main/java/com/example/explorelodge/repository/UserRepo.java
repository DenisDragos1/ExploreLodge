package com.example.explorelodge.repository;

import com.example.explorelodge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByEmailAndParola(String email, String parola);
    User findByEmail(String email);
}
