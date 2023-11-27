package com.example.explorelodge.repository;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class roleRepository {
    @Id
    @Column(name="ID", length = 45)
    @GeneratedValue
    private Long ID;

    @Column(name="nume", length = 45)
    private String nume;
    @Column(name="prenume", length = 255)
    private String prenume;
    @Column(name="email", length = 255)
    private String email;
    @Column(name="parola", length = 255)
    private String parola;
    @Column(name="tip_utilizator", length = 255)
    private String tip_utilizator;

    public roleRepository(){}
    public roleRepository(Long ID,String nume,String prenume,String email,String parola,String tip_utilizator){
        this.ID=ID;
        this.nume=nume;
        this.prenume=prenume;
        this.email=email;
        this.parola=parola;
        this.tip_utilizator=tip_utilizator;
    }


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
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

    public String getTip_utilizator() {
        return tip_utilizator;
    }

    public void setTip_utilizator(String tip_utilizator) {
        this.tip_utilizator = tip_utilizator;
    }
}