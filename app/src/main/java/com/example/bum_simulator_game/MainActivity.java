package com.example.bum_simulator_game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity{
    SharedPreferences sPref;
    final String SAVED_TEXT = "saved_text";
    Unit unit;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        create_Data();
        upload_Data();
    }

    @Override
    protected void onResume() {
        super.onResume();
        load_Data();
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
        tv.setText("Дней прожито: " + Unit.Days_Lived );

        tv = findViewById(R.id.health);
        tv.setText("Здоровье: " + Unit.Health );

        tv = findViewById(R.id.money);
        tv.setText("Деньги: " + Unit.Money);

        tv = findViewById(R.id.level);
        tv.setText("Соц. статус: " + Unit.Level);

        tv = findViewById(R.id.education);
        tv.setText("Образование: " + Unit.Education);

        tv = findViewById(R.id.work);
        tv.setText("Работа: " + Unit.Work);

        tv = findViewById(R.id.transport);
        tv.setText("Транпорт: " + Unit.Transport);

        tv = findViewById(R.id.residence);
        tv.setText("Дом: " + Unit.Residence);

        tv = findViewById(R.id.clothes);
        tv.setText("Одежда: " + Unit.Clothes);
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


    public void Open_Work_Page(View view) {
        Intent intent = new Intent(this, Works_Page.class);
        intent.putExtra("unit", unit);
        startActivity(intent);

    }

    public void Open_Health_Page(View view) {
        Intent intent = new Intent(this, Health_Page.class);
        intent.putExtra("unit", unit);
        startActivity(intent);
    }
}