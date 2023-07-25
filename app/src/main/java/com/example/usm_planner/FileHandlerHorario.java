package com.example.usm_planner;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

interface Handler{
    String[] getNombres();
}

public class FileHandlerHorario{
    private Horario horario;
    private String[] nombres;
    private File dir;

    private Context context;

    public String[] filterList(String[] list){
        ArrayList<String> r = new ArrayList<>();
        int l;
        String b;
        for(String s: list){
            l = s.length();
            b = s.substring(0,l-4);
            r.add(b);
        }
        return r.toArray(new String[0]);
    }

    public void updateNombres(){
        this.nombres = filterList(this.context.fileList());
    }

    public String[] getNombres(){
        return this.nombres;
    }

    public void setDir(File dir) {
        this.dir = dir;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void Write(String nameArch, Horario horario){
        try {
            FileOutputStream foStream = new FileOutputStream(new File(this.dir,nameArch));
            ObjectOutputStream streamArch = new ObjectOutputStream(foStream);
            streamArch.writeObject(horario);
            streamArch.close();
            Toast.makeText(this.context,"Horario Escrito",Toast.LENGTH_LONG).show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public Horario Read(String nameArch){
        try {
            FileInputStream fiStream = new FileInputStream(new File(dir,nameArch));
            ObjectInputStream streamArch = new ObjectInputStream(fiStream);
            horario = (Horario) streamArch.readObject();
            return horario;
        } catch (Exception e){
            e.printStackTrace();
            return new Horario("");
        }
    }
}
