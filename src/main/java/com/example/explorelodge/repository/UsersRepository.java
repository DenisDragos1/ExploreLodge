package com.example.explorelodge.repository;

import com.example.explorelodge.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {
    Users findByEmail(String email);
}
