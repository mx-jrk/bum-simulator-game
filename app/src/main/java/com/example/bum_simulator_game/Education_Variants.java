package com.example.bum_simulator_game;

public class Education_Variants {
    public static String Name;
    public static int Cost;
}

class Live_lessons extends Education_Variants {
    public Live_lessons(){
        Name = "Жизненные уроки";
        Cost = 0;
    }
}

class Encyclopedia extends Education_Variants{
    public Encyclopedia(){
        Name = "Знания с энциклопедий";
        Cost = 5000;
    }
}

class School extends Education_Variants{
    public School(){
        Name = "Школьное образование";
        Cost = 15000;
    }
}

class Univercity extends Education_Variants{
    public Univercity(){
        Name = "Высшее образование";
        Cost = 50000;
    }
}

