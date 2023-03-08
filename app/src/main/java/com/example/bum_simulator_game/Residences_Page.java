package com.example.bum_simulator_game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Residences_Page extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_residences_page);

        tv = findViewById(R.id.days_lived);
        tv.setText(tv.getText().toString() + Unit.Days_Lived );

        tv = findViewById(R.id.health);
        tv.setText(tv.getText().toString() + Unit.Health );

        tv = findViewById(R.id.money);
        tv.setText(tv.getText().toString() + Unit.Money);
        color_buttons();
    }

    private void color_buttons() {
        Button btn;

        btn = findViewById(R.id.res_1);
        btn.setBackgroundColor(Unit.residence_status(btn.getText().toString()));

        btn = findViewById(R.id.res_2);
        btn.setBackgroundColor(Unit.residence_status(btn.getText().toString()));

        btn = findViewById(R.id.res_3);
        btn.setBackgroundColor(Unit.residence_status(btn.getText().toString()));

        btn = findViewById(R.id.res_4);
        btn.setBackgroundColor(Unit.residence_status(btn.getText().toString()));

        btn = findViewById(R.id.res_5);
        btn.setBackgroundColor(Unit.residence_status(btn.getText().toString()));

        btn = findViewById(R.id.res_6);
        btn.setBackgroundColor(Unit.residence_status(btn.getText().toString()));

        btn = findViewById(R.id.res_7);
        btn.setBackgroundColor(Unit.residence_status(btn.getText().toString()));
        btn = findViewById(R.id.res_8);
        btn.setBackgroundColor(Unit.residence_status(btn.getText().toString()));

    }

    public void residence_selected(View view) {
        Unit.find_Residence(((Button) view).getText().toString());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(Residence_Variants.Name);
        if (Unit.residence_status(Residence_Variants.Name) != 0xFF3700B3 || Unit.Money < Residence_Variants.Cost){
            builder.setMessage("Вы не можете купить это жильё, так как не удовлетворяете одному из минимальных требований:\n\n" +
                    "Жильё: У вас не куплено предыдущее жильё\n" +
                    "Жильё: У вас уже куплено это жильё\n"  +
                    "Стоимость: " + Residence_Variants.Cost);
            builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // Кнопка ОК
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss(); // Отпускает диалоговое окно
                }
            });
            builder.create().show();
        }
        else {
            builder.setMessage("Вы можете приобрести это жильё!\nЗатраты на выполние действия:\n" +
                    "Стоимость: " + Residence_Variants.Cost);
            builder.setPositiveButton("Купить!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss(); // Отпускает диалоговое окно
                    buy_residence();
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

    private void buy_residence() {
        Unit.Money -= Residence_Variants.Cost;
        Unit.Residence = Residence_Variants.Name;

        tv = findViewById(R.id.money);
        tv.setText(tv.getText().toString().split(" ")[0] +" " +  Unit.Money);
        color_buttons();
    }

    public void go_to_mainPage(View view) {
        finish();
    }
}