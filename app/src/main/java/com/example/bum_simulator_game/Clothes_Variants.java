package com.example.bum_simulator_game;

public class Clothes_Variants {
    public static String Name;
    public static int Cost;
}

class Dump extends Clothes_Variants{
    public Dump(){
        Name = "Шмот с помойки";
        Cost = 0;
    }
}

class Market extends Clothes_Variants{
    public Market(){
        Name = "Одежда с рынка";
        Cost = 500;
    }
}

class Second extends Clothes_Variants{
    public Second(){
        Name = "Одежда из секонда";
        Cost = 1000;
    }
}

class Shop extends Clothes_Variants{
    public Shop(){
        Name = "Одежда из фирменного магазина";
        Cost = 5000;
    }
}

class Office extends Clothes_Variants{
    public Office(){
        Name = "Офисый костюм";
        Cost = 15000;
    }
}
class Italian extends Clothes_Variants{
    public Italian(){
        Name = "Итальянский смокинг";
        Cost = 100000;
    }
}
