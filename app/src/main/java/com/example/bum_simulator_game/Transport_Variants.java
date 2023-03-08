package com.example.bum_simulator_game;

public class Transport_Variants {
    public static String Name;
    public static int Cost;
}

class Legs extends Transport_Variants{
    public Legs(){
        Name = "Ноги";
        Cost = 0;
    }
}

class Bicycle extends Transport_Variants{
    public Bicycle(){
        Name = "Велик";
        Cost = 2000;
    }
}

class Moto extends Transport_Variants{
    public Moto(){
        Name = "Мотоцикл";
        Cost = 6000;
    }
}

class Zhiga extends Transport_Variants{
    public Zhiga(){
        Name = "Жига";
        Cost = 10000;
    }
}

class Cheap_car extends Transport_Variants{
    public Cheap_car(){
        Name = "Автомобиль среднего класса";
        Cost = 30000;
    }
}

class Expencive_car extends Transport_Variants{
    public Expencive_car(){
        Name = "Автомобиль бизнес класса";
        Cost = 100000;
    }
}

class Helicopter extends Transport_Variants{
    public Helicopter(){
        Name = "Личный вертолет";
        Cost = 1000000;
    }
}

class Airplane extends Transport_Variants{
    public Airplane(){
        Name = "Личный самолет";
        Cost = 10000000;
    }
}
