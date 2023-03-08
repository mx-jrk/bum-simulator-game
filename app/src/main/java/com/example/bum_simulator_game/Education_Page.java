package com.example.bum_simulator_game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class Education_Page extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_page);
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
        int res;

        btn = findViewById(R.id.edu_1);
        res = Unit.edu_status(btn.getText().toString());
        if (res != 0) btn.setBackgroundColor(res);

        btn = findViewById(R.id.edu_2);
        res = Unit.edu_status(btn.getText().toString());
        if (res != 0) btn.setBackgroundColor(res);

        btn = findViewById(R.id.edu_3);
        res = Unit.edu_status(btn.getText().toString());
        if (res != 0) btn.setBackgroundColor(res);

        btn = findViewById(R.id.edu_4);
        res = Unit.edu_status(btn.getText().toString());
        if (res != 0) btn.setBackgroundColor(res);
    }

    public void education_selected(View view) {
        Unit.fing_Education(((Button) view).getText().toString());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(Education_Variants.Name);
        if (Unit.edu_status(Education_Variants.Name) != 0){
            builder.setMessage("Вы не можете получить это образование, так как не удовлетворяете одному из минимальных требований:\n"+
                    "Образование: Вы не получили предыдущее образование\n" +
                    "Образование: Вы уже получили это образование\n"+
                    "Стоимость: " + Education_Variants.Cost);
            builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // Кнопка ОК
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss(); // Отпускает диалоговое окно
                }
            });
            builder.create().show();
        }
        else {
            builder.setMessage("Вы можете получить это образование!\n" + "Затраты на выполнение действия:\n" +
                    "Стоимость: " + Education_Variants.Cost);
            builder.setPositiveButton("Обучиться!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss(); // Отпускает диалоговое окно
                    go_edu();
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

    private void go_edu() {
        Unit.Money -= Education_Variants.Cost;
        Unit.Education = Education_Variants.Name;

        tv = findViewById(R.id.money);
        tv.setText(tv.getText().toString().split(" ")[0] +" " +  Unit.Money);
        color_buttons();
    }

    public void go_to_mainPage(View view) {
        finish();
    }
}