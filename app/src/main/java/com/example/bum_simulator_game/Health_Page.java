package com.example.bum_simulator_game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Health_Page extends AppCompatActivity {
    TextView tv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_page);

        tv = findViewById(R.id.days_lived);
        tv.setText(tv.getText().toString() + Unit.Days_Lived );

        tv = findViewById(R.id.health);
        tv.setText(tv.getText().toString() + Unit.Health );

        tv = findViewById(R.id.money);
        tv.setText(tv.getText().toString() + Unit.Money);
        color_buttons();
    }

    private void color_buttons(){
        btn = findViewById(R.id.health_1);
        Unit.find_Health(btn.getText().toString());
        if (!Unit.can_Do(Health_Variants.Name, Health_Variants.Cost)) btn.setBackgroundColor(Color.RED);

        btn = findViewById(R.id.health_2);
        Unit.find_Health(btn.getText().toString());
        if (!Unit.can_Do(Health_Variants.Name, Health_Variants.Cost)) btn.setBackgroundColor(Color.RED);

        btn = findViewById(R.id.health_3);
        Unit.find_Health(btn.getText().toString());
        if (!Unit.can_Do(Health_Variants.Name, Health_Variants.Cost)) btn.setBackgroundColor(Color.RED);

        btn = findViewById(R.id.health_4);
        Unit.find_Health(btn.getText().toString());
        if (!Unit.can_Do(Health_Variants.Name, Health_Variants.Cost)) btn.setBackgroundColor(Color.RED);

        btn = findViewById(R.id.health_5);
        Unit.find_Health(btn.getText().toString());
        if (!Unit.can_Do(Health_Variants.Name, Health_Variants.Cost)) btn.setBackgroundColor(Color.RED);

        btn = findViewById(R.id.health_6);
        Unit.find_Health(btn.getText().toString());
        if (!Unit.can_Do(Health_Variants.Name, Health_Variants.Cost)) btn.setBackgroundColor(Color.RED);
    }


    public void health_selected(View view) {
        Unit.find_Health(((Button) view).getText().toString());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(Health_Variants.Name);
        if (!Unit.can_Do(Health_Variants.Name, Health_Variants.Cost)){
            builder.setMessage("Вы не можете лечиться этим способом, так как не удовлетворяете минимальному требованию:\n" +
                    "Стоимость: " + Health_Variants.Cost);
            builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() { // Кнопка ОК
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss(); // Отпускает диалоговое окно
                }
            });
            builder.create().show();
        }
        else {
            builder.setMessage("Вы можете лечиться этим способом!\nЗдоровье: +" + Health_Variants.Effect+
                    "\nЗатраты на выполнение действия:\nСтоимость: " + Health_Variants.Cost);
            builder.setPositiveButton("Лечиться!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss(); // Отпускает диалоговое окно
                    go_health();
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

    private void go_health(){
        Unit.Health += Health_Variants.Effect;
        Unit.Money -= Health_Variants.Cost;

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