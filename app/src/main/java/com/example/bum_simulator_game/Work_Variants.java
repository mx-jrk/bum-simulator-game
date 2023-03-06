package com.example.bum_simulator_game;

public class Work_Variants {
    public static String Name;
    public static int Health_Сosts;
    public static int Income;
    public static int Investment;
    public static int Health_Conditions;
    public static String Education_Conditions;
    public static int Days_Skip;
}

class Trash_Heaps extends Work_Variants {

    public Trash_Heaps() {
        Name = "Порыться на помойках";
        Health_Сosts = 10;
        Income = 50;
        Investment = 0;
        Health_Conditions = Health_Сosts + 10;
        Education_Conditions = "Жизненные уроки";
        Days_Skip = 1;
    }
}

class Rob_Stall extends Work_Variants {
    public Rob_Stall(){
        Name = "Грабануть ларек";
        Health_Сosts = 50;
        Income = 250;
        Investment = 0;
        Health_Conditions = Health_Сosts + 10;
        Education_Conditions = "Жизненные уроки";
        Days_Skip = 1;
    }
}

class Fight extends Work_Variants {
    public Fight (){
        Name = "Подраться на нелегальных боях";
        Health_Сosts = 70;
        if (Math.random()*2 > 0.5)
            Income = 2000;
        else
            Income = 0;
        Investment = 1000;
        Health_Conditions = Health_Сosts + 10;
        Education_Conditions = "Жизненные уроки";
        Days_Skip = 1;
    }
}

class Flyers extends Work_Variants {
    public Flyers(){
        Name = "Раздавать листовки";
        Health_Сosts = 10;
        Income = 100;
        Investment = 0;
        Health_Conditions = Health_Сosts + 10;
        Education_Conditions = "Знания с энциклопедий";
        Days_Skip = 1;
    }
}
class Courier extends Work_Variants {
    public Courier(){
        Name = "Доставлять еду";
        Health_Сosts = 20;
        Income = 200;
        Investment = 0;
        Health_Conditions = Health_Сosts + 10;
        Education_Conditions = "Знания с энциклопедий";
        Days_Skip = 1;
    }
}

class  Handyman extends Work_Variants {
    public  Handyman(){
        Name = "Шабашить на стройках";
        Health_Сosts = 30;
        Income = 300;
        Investment = 0;
        Health_Conditions = Health_Сosts + 10;
        Education_Conditions = "Знания с энциклопедий";
        Days_Skip = 1;
    }
}

class Builder extends Work_Variants {
    public Builder(){
        Name = "Строитель";
        Health_Сosts = 70;
        Income = 1000;
        Investment = 0;
        Health_Conditions = Health_Сosts + 10;
        Education_Conditions = "Школьное образование";
        Days_Skip = 5;
    }
}

class Welder extends Work_Variants {
    public Welder(){
        Name = "Сварщик";
        Health_Сosts = 50;
        Income = 700;
        Investment = 0;
        Health_Conditions = Health_Сosts + 10;
        Education_Conditions = "Школьное образование";
        Days_Skip = 3;
    }
}

class Seller extends Work_Variants {
    public Seller(){
        Name = "Продавец";
        Health_Сosts = 60;
        Income = 850;
        Investment = 0;
        Health_Conditions = Health_Сosts + 10;
        Education_Conditions = "Школьное образование";
        Days_Skip = 4;
    }
}

class Assistaint extends Work_Variants {
    public Assistaint(){
        Name = "Ассистент в офисе";
        Health_Сosts = 50;
        Income = 1500;
        Investment = 0;
        Health_Conditions = Health_Сosts + 10;
        Education_Conditions = "Высшее образование";
        Days_Skip = 3;
    }
}

class Manager extends Work_Variants {
    public Manager(){
        Name = "Менеджер по продажам";
        Health_Сosts = 60;
        Income = 2000;
        Investment = 0;
        Health_Conditions = Health_Сosts + 10;
        Education_Conditions = "Высшее образование";
        Days_Skip = 4;
    }
}

class Chief extends Work_Variants {
    public Chief(){
        Name = "Начальник в офисе";
        Health_Сosts = 35;
        Income = 4000;
        Investment = 0;
        Health_Conditions = Health_Сosts + 10;
        Education_Conditions = "Высшее образование";
        Days_Skip = 3;
    }
}

class Investor extends Work_Variants {
    public Investor(){
        Name = "Инвестор";
        Health_Сosts = 40;
        if (Math.random()*2 > 0.5)
            Income = 10000;
        else
            Income = 0;
        Investment = 5000;
        Health_Conditions = Health_Сosts + 10;
        Education_Conditions = "Высшее образование";
        Days_Skip = 1;
    }
}

class General_Manager extends Work_Variants {
    public General_Manager(){
        Name = "Генеральный директор";
        Health_Сosts = 70;
        Income = 300000;
        Investment = 100000;
        Health_Conditions = Health_Сosts + 10;
        Education_Conditions = "Высшее образование";
        Days_Skip = 30;
    }
}

class Deputy extends Work_Variants {
    public Deputy(){
        Name = "Депутат";
        Health_Сosts = 50;
        Income = 2000000;
        Investment = 1000000;
        Health_Conditions = Health_Сosts + 10;
        Education_Conditions = "Высшее образование";
        Days_Skip = 30;
    }
}

class President extends Work_Variants {
    public President(){
        Name = "Президент";
        Health_Сosts = 35;
        Income = 150000000;
        Investment = 100000000;
        Health_Conditions = Health_Сosts + 10;
        Education_Conditions = "Высшее образование";
        Days_Skip = 20;
    }
}