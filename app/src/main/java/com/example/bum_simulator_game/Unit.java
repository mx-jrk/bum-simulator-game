package com.example.bum_simulator_game;

import java.io.File;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.content.SharedPreferences.Editor;
import android.widget.Toast;

public class Unit implements Serializable {
    private static String[] LEVELS = {"Бомж", "Образованный бомж", "На грани бедности", "Средний класс", "Статусный человек", "Бизнесмен", "Президент"};
    private static String[] EDUCATIONS = {"Жизненные уроки", "Знания с энциклопедий", "Школьное образование", "Высшее образование"};
    private static String[] WORKS = {"Порыться на помойках", "Грабануть ларек", "Подраться на нелегальных боях",
            "Раздавать листовки", "Доставлять еду", "Шабашить на стройках",
            "Строитель", "Сварщик", "Продавец",
            "Ассистент в офисе", "Менеджер по продажам",
            "Начальник в офисе", "Инвестор",
            "Гениральный директор",
            "Депутат", "Президент"};
    private static String[] TRANSPORTS = {"Ноги, Велик, Мотоцикл, Жига, Автомобиль среднего класса, Автомобиль бизнес класса, Личный вертолет, Личный самолет"};
    private static String[] RESIDENCES = {"Подземка", "Палатка", "Койка в общаге", "Комната у бабки", "Съемная квартирка", "Съемные аппартаменты", "Квартира", "Дом", "Особняк"};
    private static String[] CLOTHES = {"Шмот с помойки", "Одежда с рынка", "Одежда из секонда", "Одежда из фирменного магазина", "Офисый костюм", "Итальянский смокинг"};

    public static int Days_Lived;
    public static int Health;
    public static int Money;

    public static String Level;
    public static String Education;
    public static String Work;
    public static String Transport;
    public static String Residence;
    public static String Clothes;

    public static void set_Values(String[] data) {
        Days_Lived = Integer.parseInt(data[0]);
        Health = Integer.parseInt(data[1]);
        Money = Integer.parseInt(data[2]);
        Level = data[3];
        Education = data[4];
        Work = data[5];
        Transport = data[6];
        Residence = data[7];
        Clothes = data[8];
    }
    private static int indexOf(String[] arr, String s){
        for (int i = 0; i < arr.length; i++)
            if (Objects.equals(arr[i], s)) return i;
        return -1;
    }
    public static boolean can_Work(String work_edu, int inv){
        return indexOf(EDUCATIONS, Education) >= indexOf(EDUCATIONS, work_edu) && Money >= inv;
    }

    public static Work_Variants find_Work(String select_work) {

        if (select_work.equals(new Trash_Heaps().Name)){
            System.out.println(select_work + " " + new Trash_Heaps().Name);
            return new Trash_Heaps();
        }
        if (select_work.equals(new Rob_Stall().Name) ){
            return new Rob_Stall();
        }
        if (select_work.equals(new Fight().Name) ){
            return new Fight();
        }
        if (select_work.equals(new Flyers().Name) ){
            return new Flyers();
        }
        if (select_work.equals(new Courier().Name) ){
            return new Courier();
        }
        if (select_work.equals( new Handyman().Name)){
            return new Handyman();
        }
        if (select_work.equals(new Builder().Name) ){
            return new Builder();
        }
        if (select_work.equals(new Welder().Name) ){
            return new Welder();
        }
        if (select_work.equals(new Seller().Name) ){
            return new Seller();
        }
        if (select_work.equals(new Assistaint().Name) ){
            return new Assistaint();
        }
        if (select_work.equals( new Manager().Name)){
            return new Manager();
        }
        if (select_work.equals( new Chief().Name)){
            return new Chief();
        }
        if (select_work.equals(new Investor().Name) ){
            return new Investor();
        }
        if (select_work.equals(new General_Manager().Name) ){
            return new General_Manager();
        }
        if (select_work.equals(new Deputy().Name) ){
            return new Deputy();
        }
        if (select_work.equals(new President().Name) ){
            return new President();
        }
        return new Work_Variants();
    }
}

