package com.example.bum_simulator_game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Transports_Page extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transports_page);

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

        btn = findViewById(R.id.transp_1);
        btn.setBackgroundColor(Unit.transport_status(btn.getText().toString()));

        btn = findViewById(R.id.transp_2);
        btn.setBackgroundColor(Unit.transport_status(btn.getText().toString()));

        btn = findViewById(R.id.transp_3);
        btn.setBackgroundColor(Unit.transport_status(btn.getText().toString()));

        btn = findViewById(R.id.transp_4);
        btn.setBackgroundColor(Unit.transport_status(btn.getText().toString()));

        btn = findViewById(R.id.transp_5);
        btn.setBackgroundColor(Unit.transport_status(btn.getText().toString()));

        btn = findViewById(R.id.transp_6);
        btn.setBackgroundColor(Unit.transport_status(btn.getText().toString()));

        btn = findViewById(R.id.transp_7);
        btn.setBackgroundColor(Unit.transport_status(btn.getText().toString()));

        btn = findViewById(R.id.transp_8);
        btn.setBackgroundColor(Unit.transport_status(btn.getText().toString()));

    }

    public void transport_selected(View view) {
        Unit.find_Transport(((Button) view).getText().toString());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(Transport_Variants.Name);
        if (Unit.transport_status(Transport_Variants.Name) != 0xFF3700B3){
            builder.setMessage("Вы не можете купить этот транспорт, так как не удовлетворяете одному из минимальных требований:\n\n" +
                    "Транспорт: У вас не куплен предыдущий транспорт\n" +
                    "Транспорт: У вас уже куплен этот траспорт\n"  +
                    "Стоимость: " + Transport_Variants.Cost);
            builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // Кнопка ОК
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss(); // Отпускает диалоговое окно
                }
            });
            builder.create().show();
        }
        else {
            builder.setMessage("Вы можете приобрести этот транспорт!\nЗатраты на выполние действия:\n" +
                    "Стоимость: " + Transport_Variants.Cost);
            builder.setPositiveButton("Купить!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss(); // Отпускает диалоговое окно
                    buy_car();
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

    private void buy_car() {
        Unit.Money -= Transport_Variants.Cost;
        Unit.Transport = Transport_Variants.Name;

        tv = findViewById(R.id.money);
        tv.setText(tv.getText().toString().split(" ")[0] +" " +  Unit.Money);
        color_buttons();
    }

    public void go_to_mainPage(View view) {
        finish();
    }
}
