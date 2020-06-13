package com.example.terrariapotions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.terrariapotions.View.PotionActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.test);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, PotionActivity.class);
            startActivity(intent);
        });
    }
}
