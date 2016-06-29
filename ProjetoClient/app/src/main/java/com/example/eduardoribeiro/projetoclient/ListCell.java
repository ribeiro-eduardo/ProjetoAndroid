package com.example.eduardoribeiro.projetoclient;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Eduardo Ribeiro on 29/06/2016.
 */
public class ListCell extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] endereco;

    public ListCell(Activity context, String[] endereco){
        super(context, R.layout.list_cell, endereco);
        this.context = context;
        this.endereco = endereco;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_cell, null, true);

        TextView txtEndereco = (TextView)rowView.findViewById(R.id.txtEndereco);

        txtEndereco.setText(endereco[position]);

        return rowView;
    }
}
