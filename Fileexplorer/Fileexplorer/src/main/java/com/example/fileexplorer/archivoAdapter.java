package com.example.fileexplorer;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pc on 21/11/2016.
 */

public class archivoAdapter extends ArrayAdapter {
    Activity contexto;
    ArrayList<Archivo> datos;

    public archivoAdapter(Activity contexto,ArrayList<Archivo> datos) {
        super(contexto,R.layout.list_archivo,datos);
        this.contexto = contexto;
        this.datos=datos;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = contexto.getLayoutInflater();
        View item = inflater.inflate(R.layout.list_archivo, null);
        TextView lblTitulo = (TextView)item.findViewById(R.id.LblTitulo);
        TextView lblSubtitulo = (TextView) item.findViewById(R.id.LblSubTitulo);
        if(!datos.isEmpty()) {
            lblTitulo.setText(datos.get(position).getNombre());
            lblSubtitulo.setText(datos.get(position).getDirectorio());
        }
        return(item);
    }
}
