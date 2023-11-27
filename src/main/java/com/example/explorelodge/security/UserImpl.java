package com.example.explorelodge.security;

import com.example.explorelodge.entity.User;
import com.example.explorelodge.model.LoginDto;
import com.example.explorelodge.model.LoginMesage;
import com.example.explorelodge.model.UserDto;
import com.example.explorelodge.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
public class UserImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getParola(),
                getAuthorities(user.getTip_utilizator())
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role));
    }

    @Override
    public String addUser(UserDto userDto) {
        User user = new User(
                userDto.getID(),
                userDto.getNume(),
                userDto.getPrenume(),
                userDto.getEmail(),
                userDto.getTip_utilizator(),
                this.passwordEncoder.encode(userDto.getParola())
        );
        userRepo.save(user);
        return user.getNume();
    }

    @Override
    public LoginMesage loginMesage(LoginDto loginDto) {
        String msg = "";
        User user1 = userRepo.findByEmail(loginDto.getEmail());
        if (user1 != null) {
            String parola = loginDto.getParola();
            String encodedPassword = user1.getParola();
            Boolean isPwRight = passwordEncoder.matches(parola, encodedPassword);
            if (isPwRight) {
                Optional<User> user = userRepo.findByEmailAndParola(loginDto.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginMesage("Login Succes", true);
                } else {
                    return new LoginMesage("Login Failed", false);
                }
            } else {
                return new LoginMesage("Password Not Match", false);
            }
        } else {
            return new LoginMesage("Email not exists", false);
        }
    }
}
