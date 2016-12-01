package com.example.fileexplorer;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class Deducibles extends Activity {
    private Button btnCal;
    private EditText ingreso,alimentos,medicina,vestimenta,vivienda,educacion,base;
    private ArrayList<Float> lalimentos, lvivienda, lmedicina, leducacion, lvestimenta;
    private Float alData,viData,meData,edData,vesData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deducibles);

        ingreso=(EditText)findViewById(R.id.ingresoText);
        alimentos=(EditText)findViewById(R.id.editFood);
        medicina=(EditText)findViewById(R.id.editMed);
        vestimenta=(EditText)findViewById(R.id.editVest);
        vivienda=(EditText)findViewById(R.id.editViv);
        educacion=(EditText)findViewById(R.id.editEd);
        base=(EditText)findViewById(R.id.editBase);
        btnCal=(Button)findViewById(R.id.buttonCalc);
        lalimentos = (ArrayList<Float>) getIntent().getSerializableExtra("alimentos");
        lvivienda = (ArrayList<Float>) getIntent().getSerializableExtra("vivienda");
        lmedicina = (ArrayList<Float>) getIntent().getSerializableExtra("medicina");
        leducacion = (ArrayList<Float>) getIntent().getSerializableExtra("educacion");
        lvestimenta = (ArrayList<Float>) getIntent().getSerializableExtra("vestimenta");
        alData=0.0f;
        meData=0.0f;
        viData=0.0f;
        vesData=0.0f;
        edData=0.0f;
        for (Float data : lalimentos){ alData += data; }
        for (Float data : lvivienda){ viData += data; }
        for (Float data : lmedicina){ meData += data; }
        for (Float data : leducacion){ edData += data; }
        for (Float data : lvestimenta){ vesData += data; }
    }

    public void calcularDeducibles(View view){
        final Float MAX_DEDUCIBLE=14521.0f;
        final float MAX_TIPO=3630.25f;
        if(Float.parseFloat(ingreso.getText().toString())<=0)
            ingreso.setText("Haga un ingreso vÃ¡lido");
        else{
            Float maximoGasto=MAX_DEDUCIBLE;
            Float maximoTipo=MAX_TIPO;
            if(Float.parseFloat(ingreso.getText().toString())*0.50f<MAX_DEDUCIBLE) {
                maximoGasto = Float.parseFloat(ingreso.getText().toString()) * 0.50f;
                maximoTipo=maximoGasto/4;
            }
            if(alData>maximoTipo)
                alData=maximoTipo;
            if(meData>maximoTipo)
                meData=maximoTipo;
            if(vesData>maximoTipo)
                vesData=maximoTipo;
            if(viData>maximoTipo)
                viData=maximoTipo;
            if(edData>maximoTipo)
                edData=maximoTipo;
            alimentos.setText(""+alData);
            medicina.setText(""+meData);
            vestimenta.setText(""+vesData);
            vivienda.setText(""+viData);
            educacion.setText(""+edData);
            Float total=Float.parseFloat(ingreso.getText().toString())-alData-meData-vesData-viData-edData;
            base.setText(""+total);
        }
    }
}
