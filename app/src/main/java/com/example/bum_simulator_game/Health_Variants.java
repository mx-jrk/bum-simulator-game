package com.example.bum_simulator_game;

public class Health_Variants {
    public static String Name;
    public static int Effect;
    public static int Cost;
}

class Unlicensed_tables extends Health_Variants{
    public Unlicensed_tables() {
        Name = "Купить нелецензионные таблы";
        Effect = 40;
        Cost = 80;
    }
}

class Cheap_tablets extends Health_Variants{
    public Cheap_tablets(){
        Name = "Купить дешевые таблетки";
        Effect = 50;
        Cost = 130;
    }
}

class Sport extends Health_Variants{
    public Sport(){
        Name = "Позаниматься спортом";
        Effect = 60;
        Cost = 500;
    }
}

class Hospital extends  Health_Variants{
    public Hospital(){
        Name = "Лечь в больницу";
        Effect = 70;
        Cost = 1000;
    }
}

class Expencive_Tablets extends Health_Variants{
    public Expencive_Tablets(){
        Name = "Купить импортные препараты";
        Effect = 80;
        Cost = 10000;
    }
}

class Complex extends  Health_Variants{
    public Complex(){
        Name = "Комплексное лечение";
        Effect = 100;
        Cost = 100000;
    }
}