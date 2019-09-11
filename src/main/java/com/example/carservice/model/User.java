package com.example.carservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String imie;
    private String nazwisko;

    @Column(name = "nazwa_użytkownika")
    private String nazwaUżytkownika;


    public User() {
    }

    public User(long id, String imie, String nazwisko, String nazwaUżytkownika) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nazwaUżytkownika = nazwaUżytkownika;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNazwaUżytkownika() {
        return nazwaUżytkownika;
    }

    public void setNazwaUżytkownika(String nazwaUżytkownika) {
        this.nazwaUżytkownika = nazwaUżytkownika;
    }
}
