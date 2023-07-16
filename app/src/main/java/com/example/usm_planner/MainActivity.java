package com.example.usm_planner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_horario, btn_notas, btn_map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_horario = findViewById(R.id.btn_horario_main);
        btn_map = findViewById(R.id.btn_main_notas);
        btn_notas = findViewById(R.id.btn_main_map);
        btn_horario.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), HorarioListActivity.class)));
    }

}