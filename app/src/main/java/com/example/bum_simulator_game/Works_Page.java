package com.example.bum_simulator_game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Works_Page extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_works_page);
        tv = findViewById(R.id.days_lived);
        tv.setText(tv.getText().toString() + Unit.Days_Lived );

        tv = findViewById(R.id.health);
        tv.setText(tv.getText().toString() + Unit.Health );

        tv = findViewById(R.id.money);
        tv.setText(tv.getText().toString() + Unit.Money);
        color_buttons();
    }

    private void color_buttons(){
        Button btn;
        btn = findViewById(R.id.work_1);
        if (!(Unit.can_Work(Unit.find_Work(btn.getText().toString()).Education_Conditions, Work_Variants.Investment) && Unit.Health >= Work_Variants.Health_Conditions)) btn.setBackgroundColor(Color.RED);

        btn = findViewById(R.id.work_2);
        if (!(Unit.can_Work(Unit.find_Work(btn.getText().toString()).Education_Conditions, Work_Variants.Investment) && Unit.Health >= Work_Variants.Health_Conditions)) btn.setBackgroundColor(Color.RED);

        btn = findViewById(R.id.work_3);
        if (!(Unit.can_Work(Unit.find_Work(btn.getText().toString()).Education_Conditions, Work_Variants.Investment) && Unit.Health >= Work_Variants.Health_Conditions)) btn.setBackgroundColor(Color.RED);

        btn = findViewById(R.id.work_4);
        if (!(Unit.can_Work(Unit.find_Work(btn.getText().toString()).Education_Conditions, Work_Variants.Investment) && Unit.Health >= Work_Variants.Health_Conditions)) btn.setBackgroundColor(Color.RED);

        btn = findViewById(R.id.work_5);
        if (!(Unit.can_Work(Unit.find_Work(btn.getText().toString()).Education_Conditions, Work_Variants.Investment) && Unit.Health >= Work_Variants.Health_Conditions)) btn.setBackgroundColor(Color.RED);

        btn = findViewById(R.id.work_6);
        if (!(Unit.can_Work(Unit.find_Work(btn.getText().toString()).Education_Conditions, Work_Variants.Investment) && Unit.Health >= Work_Variants.Health_Conditions)) btn.setBackgroundColor(Color.RED);

        btn = findViewById(R.id.work_7);
        if (!(Unit.can_Work(Unit.find_Work(btn.getText().toString()).Education_Conditions, Work_Variants.Investment) && Unit.Health >= Work_Variants.Health_Conditions)) btn.setBackgroundColor(Color.RED);

        btn = findViewById(R.id.work_8);
        if (!(Unit.can_Work(Unit.find_Work(btn.getText().toString()).Education_Conditions, Work_Variants.Investment) && Unit.Health >= Work_Variants.Health_Conditions)) btn.setBackgroundColor(Color.RED);

        btn = findViewById(R.id.work_9);
        if (!(Unit.can_Work(Unit.find_Work(btn.getText().toString()).Education_Conditions, Work_Variants.Investment) && Unit.Health >= Work_Variants.Health_Conditions)) btn.setBackgroundColor(Color.RED);

        btn = findViewById(R.id.work_10);
        if (!(Unit.can_Work(Unit.find_Work(btn.getText().toString()).Education_Conditions, Work_Variants.Investment) && Unit.Health >= Work_Variants.Health_Conditions)) btn.setBackgroundColor(Color.RED);

        btn = findViewById(R.id.work_11);
        if (!(Unit.can_Work(Unit.find_Work(btn.getText().toString()).Education_Conditions, Work_Variants.Investment) && Unit.Health >= Work_Variants.Health_Conditions)) btn.setBackgroundColor(Color.RED);

        btn = findViewById(R.id.work_12);
        if (!(Unit.can_Work(Unit.find_Work(btn.getText().toString()).Education_Conditions, Work_Variants.Investment) && Unit.Health >= Work_Variants.Health_Conditions)) btn.setBackgroundColor(Color.RED);

        btn = findViewById(R.id.work_13);
        if (!(Unit.can_Work(Unit.find_Work(btn.getText().toString()).Education_Conditions, Work_Variants.Investment) && Unit.Health >= Work_Variants.Health_Conditions)) btn.setBackgroundColor(Color.RED);

        btn = findViewById(R.id.work_14);
        if (!(Unit.can_Work(Unit.find_Work(btn.getText().toString()).Education_Conditions, Work_Variants.Investment) && Unit.Health >= Work_Variants.Health_Conditions)) btn.setBackgroundColor(Color.RED);

        btn = findViewById(R.id.work_15);
        if (!(Unit.can_Work(Unit.find_Work(btn.getText().toString()).Education_Conditions, Work_Variants.Investment) && Unit.Health >= Work_Variants.Health_Conditions)) btn.setBackgroundColor(Color.RED);

        btn = findViewById(R.id.work_16);
        if (!(Unit.can_Work(Unit.find_Work(btn.getText().toString()).Education_Conditions, Work_Variants.Investment) && Unit.Health >= Work_Variants.Health_Conditions)) btn.setBackgroundColor(Color.RED);
    }

    public void work_selected(View view) {
        Unit.find_Work(((Button) view).getText().toString());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (!(Unit.can_Work(Work_Variants.Education_Conditions, Work_Variants.Investment) && Unit.Health >= Work_Variants.Health_Conditions)){
            builder.setTitle(Work_Variants.Name);
            builder.setMessage("Вы не можете выполнять эту работу, так как не употребляете одному из минимальных требований:\n\n" +
                    "Здоровье: " + Work_Variants.Health_Conditions + "\n" +
                    "Образование: " + Work_Variants.Education_Conditions + "\n" +
                    "Вложения: " + Work_Variants.Investment);
            builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // Кнопка ОК
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss(); // Отпускает диалоговое окно
                }
            });
            builder.create().show();
            return;
        }
        else {
            builder.setTitle(Work_Variants.Name);
            builder.setMessage("Вы можете выполнить эту работу. Доход: " + Work_Variants.Income + "\n" + "Затраты на выполнение действия:\n\n" +
                    "Здоровье: " + Work_Variants.Health_Conditions + "\n" +
                    "Образование: " + Work_Variants.Education_Conditions + "\n" +
                    "Вложения: " + Work_Variants.Investment);
            builder.setPositiveButton("Работать!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss(); // Отпускает диалоговое окно
                    go_work();
                }
            });
            builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss(); // Отпускает диалоговое окно

                }
            });
            builder.create().show();
        }

    }
    public void go_work(){
        Unit.Health -= Work_Variants.Health_Сosts;
        Unit.Money += Work_Variants.Income;
        Unit.Money -= Work_Variants.Investment;
        Unit.Days_Lived += Work_Variants.Days_Skip;
        Unit.Work = Work_Variants.Name;
        System.out.println(Unit.Money);
        tv = findViewById(R.id.days_lived);
        tv.setText(tv.getText().toString().split(" ")[0] + " " + Unit.Days_Lived );

        tv = findViewById(R.id.health);
        tv.setText(tv.getText().toString().split(" ")[0] + " " + Unit.Health );

        tv = findViewById(R.id.money);
        tv.setText(tv.getText().toString().split(" ")[0] +" " +  Unit.Money);
        color_buttons();
    }

    public void go_to_mainPage(View view) {
        finish();
    }
}