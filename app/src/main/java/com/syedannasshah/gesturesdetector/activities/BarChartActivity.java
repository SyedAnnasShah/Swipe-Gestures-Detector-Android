package com.syedannasshah.gesturesdetector.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.syedannasshah.gesturesdetector.R;
import com.syedannasshah.gesturesdetector.helper.ConstantsProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.felix.horizontalbargraph.HorizontalBar;
import br.com.felix.horizontalbargraph.model.BarItem;

public class BarChartActivity extends AppCompatActivity {

    HorizontalBar barChart;
    BarChart barChartNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        barChart = findViewById(R.id.barChart);
        barChartNew = findViewById(R.id.barChartNew);
//        barChart.init(this).build();
//        barChart.init(this).build();

        List<BarItem> items = new ArrayList<>();

//Will generate the bar colors and text colors automatically randomly
        items.add(new BarItem("ZOOM IN", Double.valueOf(ConstantsProvider.GESTURE_PINCH_ZOOM_IN_BAR)));
        items.add(new BarItem("ZOOM OUT", Double.valueOf(ConstantsProvider.GESTURE_PINCH_ZOOM_OUT_BAR)));
        items.add(new BarItem("1-F RIGHT", Double.valueOf(ConstantsProvider.GESTURE_ONE_FINGER_RIGHT_BAR)));
        items.add(new BarItem("2-F RIGHT", Double.valueOf(ConstantsProvider.GESTURE_TWO_FINGER_RIGHT_BAR)));
        items.add(new BarItem("3-F DOWN", Double.valueOf(ConstantsProvider.GESTURE_THREE_FINGER_DOWN_BAR)));
        items.add(new BarItem("3-F UP", Double.valueOf(ConstantsProvider.GESTURE_THREE_FINGER_UP_BAR)));
        items.add(new BarItem("1-F LEFT", Double.valueOf(ConstantsProvider.GESTURE_ONE_FINGER_LEFT_BAR)));
        items.add(new BarItem("1-F UP", Double.valueOf(ConstantsProvider.GESTURE_ONE_FINGER_UP_BAR)));
        items.add(new BarItem("1-F DOWN", Double.valueOf(ConstantsProvider.GESTURE_ONE_FINGER_DOWN_BAR)));


//        barChart.init(this).addAll(items).build();
        barChart.init(this).addAll(items).build(new Locale("es", "ES"));

    }
}