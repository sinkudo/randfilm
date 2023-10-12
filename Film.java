package com.example.myapplication;

public class Film {
    public String name;
    public Integer year;
    public String country;
    public Integer duration;
    public Double kinopoisk;
    @Override
    public String toString(){
        return name + " " + year;
    }
}