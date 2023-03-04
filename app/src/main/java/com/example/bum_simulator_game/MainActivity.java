package com.example.bum_simulator_game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity{
    SharedPreferences sPref;
    final String SAVED_TEXT = "saved_text";

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        upload_Data();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        load_Data();
    }

    private void load_Data() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, Unit.Days_Lived + "\n" + Unit.Health + "\n" + Unit.Money +
                "\n" + Unit.Level + "\n" + Unit.Education + "\n" + Unit.Work +
                "\n" + Unit.Transport + "\n" + Unit.Residence  + "\n" + Unit.Clothes);
        ed.commit();
    }

    @SuppressLint("SetTextI18n")
    private void upload_Data() {
        sPref = getPreferences(MODE_PRIVATE);
        String info = sPref.getString(SAVED_TEXT, "");
        if (Objects.equals(info, "")) create_Data();
        Unit.set_Values(info.split("\n"));

        tv = findViewById(R.id.days_lived);
        tv.setText(tv.getText() + Integer.toString(Unit.Days_Lived));

        tv = findViewById(R.id.health);
        tv.setText(tv.getText() + Integer.toString(Unit.Health));

        tv = findViewById(R.id.money);
        tv.setText(tv.getText() + Integer.toString(Unit.Money));

        tv = findViewById(R.id.level);
        tv.setText(tv.getText() + Unit.Level);

        tv = findViewById(R.id.education);
        tv.setText(tv.getText() + Unit.Education);

        tv = findViewById(R.id.work);
        tv.setText(tv.getText() + Unit.Work);

        tv = findViewById(R.id.transport);
        tv.setText(tv.getText() + Unit.Transport);

        tv = findViewById(R.id.residence);
        tv.setText(tv.getText() + Unit.Residence);

        tv = findViewById(R.id.clothes);
        tv.setText(tv.getText() + Unit.Clothes);
    }

    private void create_Data() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, "0" + "\n" + "100" + "\n" + "500" +
                "\n" + "Бомж" + "\n" + "Жизненные уроки" + "\n" + "Безработный" +
                "\n" + "Ноги"  + "\n" + "Подземка"  + "\n" + "Шмот с помойки");
        ed.commit();
        upload_Data();
    }


}