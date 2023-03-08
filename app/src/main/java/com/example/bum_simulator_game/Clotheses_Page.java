package com.example.bum_simulator_game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Clotheses_Page extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clotheses_page);

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

        btn = findViewById(R.id.cloth_1);
        btn.setBackgroundColor(Unit.clothes_status(btn.getText().toString()));

        btn = findViewById(R.id.cloth_2);
        btn.setBackgroundColor(Unit.clothes_status(btn.getText().toString()));

        btn = findViewById(R.id.cloth_3);
        btn.setBackgroundColor(Unit.clothes_status(btn.getText().toString()));

        btn = findViewById(R.id.cloth_4);
        btn.setBackgroundColor(Unit.clothes_status(btn.getText().toString()));

        btn = findViewById(R.id.cloth_5);
        btn.setBackgroundColor(Unit.clothes_status(btn.getText().toString()));

        btn = findViewById(R.id.cloth_6);
        btn.setBackgroundColor(Unit.clothes_status(btn.getText().toString()));
    }

    public void clothes_selected(View view) {
        Unit.find_Clothes(((Button) view).getText().toString());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(Clothes_Variants.Name);
        if (Unit.clothes_status(Clothes_Variants.Name) != 0xFF3700B3 || Unit.Money < Clothes_Variants.Cost){
            builder.setMessage("Вы не можете купить эту одежду, так как не удовлетворяете одному из минимальных требований:\n\n" +
                    "Оджеда: У вас не куплена предыдущая оджеда\n" +
                    "Одежда: У вас уже куплена эта оджеда\n"  +
                    "Стоимость: " + Clothes_Variants.Cost);
            builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // Кнопка ОК
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss(); // Отпускает диалоговое окно
                }
            });
            builder.create().show();
        }
        else {
            builder.setMessage("Вы можете приобрести эту одежду!\nЗатраты на выполние действия:\n" +
                    "Стоимость: " + Clothes_Variants.Cost);
            builder.setPositiveButton("Купить!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss(); // Отпускает диалоговое окно
                    buy_clothes();
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

    private void buy_clothes() {
        Unit.Money -= Clothes_Variants.Cost;
        Unit.Clothes = Clothes_Variants.Name;

        tv = findViewById(R.id.money);
        tv.setText(tv.getText().toString().split(" ")[0] +" " +  Unit.Money);
        color_buttons();
    }

    public void go_to_mainPage(View view) {
        finish();
    }
}