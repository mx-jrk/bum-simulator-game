package com.example.bum_simulator_game;

public class Residence_Variants {
    public static String Name;
    public static int Cost;
}

class Metro extends Residence_Variants{
    public Metro(){
        Name = "Подземка";
        Cost = 0;
    }
}

class Tent extends Residence_Variants{
    public Tent(){
        Name = "Палатка";
        Cost = 1000;
    }
}

class Dorm extends Residence_Variants{
    public Dorm(){
        Name = "Койка в общаге";
        Cost = 3000;
    }
}

class Rented_flat extends Residence_Variants{
    public Rented_flat(){
        Name = "Съемная квартирка";
        Cost = 10000;
    }
}

class Rented_apartments extends Residence_Variants{
    public Rented_apartments(){
        Name = "Съемные аппартаменты";
        Cost = 20000;
    }
}

class Flat extends Residence_Variants{
    public Flat(){
        Name = "Квартира";
        Cost = 100000;
    }
}

class House extends Residence_Variants{
    public House(){
        Name = "Дом";
        Cost = 1000000;
    }
}

class Mansion extends Residence_Variants{
    public Mansion(){
        Name = "Особняк";
        Cost = 10000000;
    }
}