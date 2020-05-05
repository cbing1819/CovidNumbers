package com.example.covidnumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Yo, this is the mainActivity where everything are protaled from and to. Quite grand, innit?
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.credits);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openCreditsActivity();
            }
        });

        Button button2 = findViewById(R.id.statisticsByNation);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openNationActivity();
            }
        });

        Button button99 = findViewById(R.id.globalStatistics);
        button99.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openGlobalActivity();
            }
        });
    }

    public void openCreditsActivity() {
        Intent intent = new Intent(this, CreditsActivity.class);
        startActivity(intent);
    }

    public void openNationActivity() {
        Intent intent = new Intent(this, NationActivity.class);
        startActivity(intent);
    }

    public void openGlobalActivity() {
        Intent intent = new Intent(this, GlobalActivity.class);
        startActivity(intent);
    }
}
