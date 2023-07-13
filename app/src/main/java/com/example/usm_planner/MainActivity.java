package com.example.usm_planner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_horario, btn_notas, btn_map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_horario = findViewById(R.id.btn_horario_main);
        btn_map = findViewById(R.id.btn_main_notas);
        btn_notas = findViewById(R.id.btn_main_map);
        // onclick btn_horario
        btn_horario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), HorarioMainActivity.class));
            }
        });
    }

}