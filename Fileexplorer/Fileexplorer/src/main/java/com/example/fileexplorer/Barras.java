package com.example.fileexplorer;

import android.app.Activity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;

public class Barras extends Activity {

    private ArrayList<Float> alimentos, vivienda, medicina, educacion, vestimenta, otros;
    private String[] categoria = {"Alimentos", "Vivienda", "Medicina", "Educacion", "Vestimenta", "Otros"};
    private ArrayList<BarEntry> barEntries;
    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barras);

        alimentos = (ArrayList<Float>) getIntent().getSerializableExtra("alimentos");
        vivienda = (ArrayList<Float>) getIntent().getSerializableExtra("vivienda");
        medicina = (ArrayList<Float>) getIntent().getSerializableExtra("medicina");
        educacion = (ArrayList<Float>) getIntent().getSerializableExtra("educacion");
        vestimenta = (ArrayList<Float>) getIntent().getSerializableExtra("vestimenta");
        otros = (ArrayList<Float>) getIntent().getSerializableExtra("otros");
        alimentos.add(2.3f);
        vivienda.add(3.5f);
        medicina.add(4.5f);
        educacion.add(5.5f);
        vestimenta.add(1.2f);
        otros.add(3.5f);

        barChart = (BarChart) findViewById(R.id.barchart);

        addDataSet(barChart);

    }

    public void addDataSet(BarChart chart){

        IAxisValueFormatter formatter = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return categoria[(int)value];
            }
        };

        Float alData = 0.0f;
        Float viData = 0.0f;
        Float meData = 0.0f;
        Float edData = 0.0f;
        Float vesData = 0.0f;
        Float oData = 0.0f;

        barEntries = new ArrayList<BarEntry>();

        for (Float data : alimentos){ alData += data; }
        barEntries.add(new BarEntry(0,alData));
        for (Float data : vivienda){ viData += data; }
        barEntries.add(new BarEntry(1,viData));
        for (Float data : medicina){ meData += data; }
        barEntries.add(new BarEntry(2,meData));
        for (Float data : educacion){ edData += data; }
        barEntries.add(new BarEntry(3,edData));
        for (Float data : vestimenta){ vesData += data; }
        barEntries.add(new BarEntry(4,vesData));
        for (Float data : otros){ oData += data; }
        barEntries.add(new BarEntry(5,oData));

        BarDataSet barDataSet = new BarDataSet(barEntries,"Productos");

        XAxis xAxis = chart.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(formatter);

        BarData data = new BarData(barDataSet);
        chart.setData(data);
        chart.setContentDescription("Diagrama de Barras");

    }
}
