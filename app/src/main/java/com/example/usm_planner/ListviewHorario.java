package com.example.usm_planner;

import android.content.Context;
import android.os.Bundle;


import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

interface Listener{
    void itemClicked(int id);
}
public class ListviewHorario extends ListFragment {
    public String[] list = {};
    private Listener listener;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (Listener) context;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(list.length > 0){
            setListAdapter(new ArrayAdapter<String>(inflater.getContext(),R.layout.listview_horario,list));
        }else {
            setListAdapter(new ArrayAdapter<String>(inflater.getContext(),R.layout.listview_empty_horario,new String[]{"No se han encontrado elementos"}));
        }
        return inflater.inflate(R.layout.fragment_listview_horario,container,false);
    }

    @Override
    public void onListItemClick(ListView l,View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        listener.itemClicked(position);
    }
}