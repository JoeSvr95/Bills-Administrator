package com.example.fileexplorer;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

public class Graficos extends Activity {

    private ArrayList<Float> alimentos, vivienda, medicina, educacion, vestimenta, otros;
    private String[] xData = {"Alimentos", "Vivienda", "Medicina", "Educacion", "Vestimenta", "Otros"};
	private ArrayList<PieEntry> yEntrys;
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graficos);

        alimentos = (ArrayList<Float>) getIntent().getSerializableExtra("alimentos");
        vivienda = (ArrayList<Float>) getIntent().getSerializableExtra("vivienda");
        medicina = (ArrayList<Float>) getIntent().getSerializableExtra("medicina");
        educacion = (ArrayList<Float>) getIntent().getSerializableExtra("educacion");
        vestimenta = (ArrayList<Float>) getIntent().getSerializableExtra("vestimenta");
        otros = (ArrayList<Float>) getIntent().getSerializableExtra("otros");


        PieChart pieChart = (PieChart) findViewById(R.id.piechart);

        pieChart.setContentDescription("Compras hechas");
        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(25f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("Compras");
        pieChart.setCenterTextSize(10);

        addDataSet(pieChart);
		
		pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                String compra = e.toString().substring(17);

                int pos1 = 0;
                for (int i = 0; i < yEntrys.size(); i++){
                    if (yEntrys.get(i).getValue() == Float.parseFloat(compra)){
                        pos1 = i;
                    }
                }

                String categoria = xData[pos1];
                Toast.makeText(Graficos.this, categoria + ": $" + compra, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });
    }

    public void addDataSet(PieChart chart){

        Float alData = 0.0f;
        Float viData = 0.0f;
        Float meData = 0.0f;
        Float edData = 0.0f;
        Float vesData = 0.0f;
        Float oData = 0.0f;

        yEntrys = new ArrayList<PieEntry>();

        for (Float data : alimentos){ alData += data; }
        yEntrys.add(new PieEntry(alData));
        for (Float data : vivienda){ viData += data; }
        yEntrys.add(new PieEntry(viData));
        for (Float data : medicina){ meData += data; }
        yEntrys.add(new PieEntry(meData));
        for (Float data : educacion){ edData += data; }
        yEntrys.add(new PieEntry(edData));
        for (Float data : vestimenta){ vesData += data; }
        yEntrys.add(new PieEntry(vesData));
        for (Float data : otros){ oData += data; }
        yEntrys.add(new PieEntry(oData));

        //Creando el set de datos
        PieDataSet pieDataSet = new PieDataSet(yEntrys, "Compras");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);

        //Agregando colores
        ArrayList<Integer> colors = new ArrayList<Integer>();
        colors.add(Color.GRAY);
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.CYAN);
        colors.add(Color.YELLOW);

        pieDataSet.setColors(colors);

        //Agregando leyenda en el gráfico

        Legend legend = chart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        //Creando objetos de tipo pie
        PieData pieData = new PieData(pieDataSet);
        chart.setData(pieData);
        chart.invalidate();
    }

}
