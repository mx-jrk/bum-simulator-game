package com.example.bum_simulator_game;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.content.SharedPreferences.Editor;

public class Unit{
    public static int Days_Lived;
    public static int Health;
    public static int Money;

    public static String Level;
    public static String Education;
    public static String Work;
    public static String Transport;
    public static String Residence;
    public static String Clothes;

    public static void set_Values(String[] data){
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
}
