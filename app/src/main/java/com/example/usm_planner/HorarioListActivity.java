package com.example.usm_planner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class HorarioListActivity extends AppCompatActivity implements Listener{
    private void showBottomDialog(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.bottom_dialog_add);
        Button btn_close = (Button) bottomSheetDialog.findViewById(R.id.btn_cancel);
        Button btn_save = (Button) bottomSheetDialog.findViewById(R.id.btn_save);
        EditText text_input = (EditText) bottomSheetDialog.findViewById(R.id.inputtext_add);
        btn_close.setOnClickListener(view -> bottomSheetDialog.dismiss());
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), text_input.getText(), Toast.LENGTH_LONG).show();
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.show();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_list);
        Button btn_add = (Button) findViewById(R.id.add_horario);
        btn_add.setOnClickListener(view -> showBottomDialog());
    }
    @Override
    public void itemClicked(int id) {
        Intent intent = new Intent(this, HorarioActivity.class);
        intent.putExtra("Horario_id",id);
        startActivity(intent);
    }
}
