package com.example.usm_planner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class HorarioListActivity extends AppCompatActivity implements Listener{
    private void showBottomDialog(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.bottom_dialog_add);
        Button btn_close = (Button) bottomSheetDialog.findViewById(R.id.btn_cancel);
        Button btn_save = (Button) bottomSheetDialog.findViewById(R.id.btn_save);
        EditText text_input = (EditText) bottomSheetDialog.findViewById(R.id.inputtext_add);
        btn_close.setOnClickListener(view -> bottomSheetDialog.dismiss());
        btn_save.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), text_input.getText(), Toast.LENGTH_LONG).show();
            String Txt = text_input.getText().toString();
            Horario hor = new Horario(Txt);
            String archName = Txt+".tpo";
            File f = new File(getApplicationContext().getFilesDir(),archName);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(f);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(hor);
                objectOutputStream.close();
            } catch (Exception e){
                e.printStackTrace();
            }
            bottomSheetDialog.dismiss();
            finish();
            startActivity(getIntent());
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
    public void itemClicked(String nombre) {
        Intent intent = new Intent(this, HorarioActivity.class);
        intent.putExtra("Horario_nombre",nombre);
        startActivity(intent);
    }
}
