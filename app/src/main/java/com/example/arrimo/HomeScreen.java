package com.example.arrimo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {

    TextView helloLabel;

    Button startMyDayButton;
    Button calendarButton;
    Button settingsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        helloLabel = findViewById(R.id.helloLabel1);
        helloLabel.setText("Hallo, " + getUserName());

        startMyDayButton = findViewById(R.id.startMyDay);
        startMyDayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startMyDayButtonPressed();
            }
        });

        calendarButton = findViewById(R.id.kalendar_button);
        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendarButtonPressed();
            }
        });

        settingsButton = findViewById(R.id.settings_button);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                settingsButtonPressed();
            }
        });
    }

    public void calendarButtonPressed() {
        System.out.println("calendar button pressed");
    }

    public void settingsButtonPressed() {
        System.out.println("settings button pressed");
        Intent settingsInt = new Intent(this, Settings.class);
        startActivity(settingsInt);
    }

    public void startMyDayButtonPressed() {
        System.out.println("start my day button pressed");
    }

    public String getUserName() {
        String name = "Jorge";
        return name;
    }
}