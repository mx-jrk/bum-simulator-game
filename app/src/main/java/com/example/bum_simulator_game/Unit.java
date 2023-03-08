package com.example.bum_simulator_game;

import java.io.File;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
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
    private static String[] HEALTHS = {"Купить нелецензионные таблы", "Купить дешевые таблетки", "Позаниматься спортом",
            "Лечь в больницу", "Купить импортные препараты", "Комплексное лечение"};
    private static String[] TRANSPORTS = {"Ноги", "Велик", "Мотоцикл", "Жига", "Автомобиль среднего класса", "Автомобиль бизнес класса", "Личный вертолет", "Личный самолет"};
    private static String[] RESIDENCES = {"Подземка", "Палатка", "Койка в общаге", "Съемная квартирка", "Съемные аппартаменты", "Квартира", "Дом", "Особняк"};
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
    public static boolean can_Do(String work_edu, int inv){
        return indexOf(EDUCATIONS, Education) >= indexOf(EDUCATIONS, work_edu) && Money >= inv;
    }

    public static int clothes_status(String cloth_name){
        if (indexOf(CLOTHES, Clothes) >= indexOf(CLOTHES, cloth_name)) return Color.GREEN;
        if (indexOf(CLOTHES, Clothes) - indexOf(CLOTHES, cloth_name) != -1) return Color.RED;
        return 0xFF3700B3;
    }

    public static int residence_status(String res_name){
        if (indexOf(RESIDENCES, Residence) >= indexOf(RESIDENCES, res_name)) return Color.GREEN;
        if (indexOf(RESIDENCES, Residence) - indexOf(RESIDENCES, res_name) != -1) return Color.RED;
        return 0xFF3700B3;
    }

    public static int transport_status(String tranp_name){
        if (indexOf(TRANSPORTS, Transport) >= indexOf(TRANSPORTS, tranp_name)) return Color.GREEN;
        if (indexOf(TRANSPORTS, Transport) - indexOf(TRANSPORTS, tranp_name) != -1) return Color.RED;
        return 0xFF3700B3;
    }
    public static int edu_status(String edu_name) {
       if (indexOf(EDUCATIONS, Education) >= indexOf(EDUCATIONS, edu_name)) return Color.GREEN;
       if (indexOf(EDUCATIONS, Education) - indexOf(EDUCATIONS, edu_name) != -1) return Color.RED;
       return 0xFF3700B3;
    }

    public static Clothes_Variants find_Clothes(String selected_clothes){
        if (selected_clothes.equals(new Dump().Name)) return new Dump();
        if (selected_clothes.equals(new Market().Name)) return new Market();
        if (selected_clothes.equals(new Second().Name)) return new Second();
        if (selected_clothes.equals(new Shop().Name)) return new Shop();
        if (selected_clothes.equals(new Office().Name)) return new Office();
        if (selected_clothes.equals(new Italian().Name)) return new Italian();
        return new Clothes_Variants();

    }

    public static Residence_Variants find_Residence(String selected_residence){
        if (selected_residence.equals(new Metro().Name)) return new Metro();
        if (selected_residence.equals(new Tent().Name)) return new Tent();
        if (selected_residence.equals(new Dorm().Name)) return new Dorm();
        if (selected_residence.equals(new Rented_flat().Name)) return new Rented_flat();
        if (selected_residence.equals(new Rented_apartments().Name)) return new Rented_apartments();
        if (selected_residence.equals(new Flat().Name)) return new Flat();
        if (selected_residence.equals(new House().Name)) return new House();
        if (selected_residence.equals(new Mansion().Name)) return new Mansion();
        return new Residence_Variants();
    }

    public static Transport_Variants find_Transport(String selected_transport){
        if (selected_transport.equals(new Legs().Name)) return new Legs();
        if (selected_transport.equals(new Bicycle().Name)) return new Bicycle();
        if (selected_transport.equals(new Moto().Name)) return new Moto();
        if (selected_transport.equals(new Zhiga().Name)) return new Zhiga();
        if (selected_transport.equals(new Cheap_car().Name)) return new Cheap_car();
        if (selected_transport.equals(new Expencive_car().Name)) return new Expencive_car();
        if (selected_transport.equals(new Helicopter().Name)) return new Helicopter();
        if (selected_transport.equals(new Airplane().Name)) return new Airplane();
        return new Transport_Variants();
    }

    public static Education_Variants fing_Education(String select_education){
        if (select_education.equals(new Live_lessons().Name)) return new Live_lessons();
        if (select_education.equals(new Encyclopedia().Name)) return new Encyclopedia();
        if (select_education.equals(new School().Name)) return new School();
        if (select_education.equals(new Univercity().Name)) return new Univercity();
        return new Education_Variants();
    }

    public static Health_Variants find_Health(String select_health){
        if (select_health.equals(new Unlicensed_tables().Name)) return new Unlicensed_tables();
        if (select_health.equals(new Cheap_tablets().Name)) return new Cheap_tablets();
        if (select_health.equals(new Sport().Name)) return new Sport();
        if (select_health.equals(new Hospital().Name)) return new Hospital();
        if (select_health.equals(new Expencive_Tablets().Name)) return new Expencive_Tablets();
        if (select_health.equals(new Complex().Name)) return new Complex();
        return new Health_Variants();
    }

    public static Work_Variants find_Work(String select_work) {

        if (select_work.equals(new Trash_Heaps().Name)){
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

