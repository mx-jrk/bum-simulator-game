package com.example.bum_simulator_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Works_Page extends AppCompatActivity {
    SharedPreferences sPref;
    final String SAVED_TEXT = "saved_text";

    Unit unit;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_works_page);
        unit = (Unit) getIntent().getSerializableExtra("unit");
        tv = findViewById(R.id.days_lived);
        tv.setText(tv.getText().toString() + Unit.Days_Lived );

        tv = findViewById(R.id.health);
        tv.setText(tv.getText().toString() + Unit.Health );

        tv = findViewById(R.id.money);
        tv.setText(tv.getText().toString() + Unit.Money);
    }

    public void work_selected(View view) {
        Work_Variants work = Unit.find_Work(((Button) view).getText().toString());
        Unit.Health -= Work_Variants.Health_Сosts;
        Unit.Money += Work_Variants.Income;
        Unit.Money -= Work_Variants.Investment;
        Unit.Days_Lived += Work_Variants.Days_Skip;
        System.out.println(Unit.Money);
        tv = findViewById(R.id.days_lived);
        tv.setText(tv.getText().toString().split(" ")[0] + " " + Unit.Days_Lived );

        tv = findViewById(R.id.health);
        tv.setText(tv.getText().toString().split(" ")[0] + " " + Unit.Health );

        tv = findViewById(R.id.money);
        tv.setText(tv.getText().toString().split(" ")[0] +" " +  Unit.Money);
    }

    public void go_to_mainPage(View view) {

        finish();
    }
}