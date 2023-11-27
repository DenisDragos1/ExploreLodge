package com.example.explorelodge.model;

public class LoginDto {
    private String email;
    private String parola;

    public LoginDto(){

    }
    public LoginDto(String email,String parola)
    {
        this.email=email;
        this.parola=parola;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }
}
