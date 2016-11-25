package com.example.fileexplorer;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ADMIN-MINEDUC on 20/11/2016.
 */

//ESTA CLASE SE IMPLEMENTO PARA QUE EL LISTVIEW PUEDA CARGARSE CON EL NOMBRE Y DIRECTORIO DEL XML
public class Archivo implements Parcelable{
    private String nombre;
    private String directorio;

    public Archivo(String nombre, String directorio) {
        this.nombre = nombre;
        this.directorio = directorio;
    }

    protected Archivo(Parcel in) {
        nombre = in.readString();
        directorio = in.readString();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirectorio() {
        return directorio;
    }

    public void setDirectorio(String directorio) {
        this.directorio = directorio;
    }


    public boolean equals(Object o) {
        if(o instanceof Archivo){
            o=(Archivo) o;
            if(this.nombre.equals(((Archivo) o).nombre) && this.directorio.equals(((Archivo) o).directorio))
                return true;
        }
        return false;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(directorio);
    }

    public static final Creator<Archivo> CREATOR = new Creator<Archivo>() {
        @Override
        public Archivo createFromParcel(Parcel in) {
            return new Archivo(in);
        }

        @Override
        public Archivo[] newArray(int size) {
            return new Archivo[size];
        }
    };

}
