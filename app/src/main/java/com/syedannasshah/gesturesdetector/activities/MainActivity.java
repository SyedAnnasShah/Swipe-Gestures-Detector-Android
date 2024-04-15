package com.syedannasshah.gesturesdetector.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.syedannasshah.gesturesdetector.R;
import com.syedannasshah.gesturesdetector.helper.ConstantsProvider;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout clThreeFingerSwipeDown, clThreeFingerSwipeUp, cl2FingerSwipeRight,
            cl1FingerSwipeRight, clPinchZoomIn, clPinchZoomOut,
            cl1FingerSwipeLeft, cl1FingerSwipeUp, cl1FingerSwipeDown, clBarChart;

    private int pi0po1ofr2tfr3tfd4tfu5ofl6ofu7ofd8 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeVariables();
        setClickListeners();

    }

    private void initializeVariables() {

        clThreeFingerSwipeDown = findViewById(R.id.clThreeFingerSwipeDown);
        clThreeFingerSwipeUp = findViewById(R.id.clThreeFingerSwipeUp);
        cl2FingerSwipeRight = findViewById(R.id.cl2FingerSwipeRight);
        cl1FingerSwipeRight = findViewById(R.id.cl1FingerSwipeRight);
        clPinchZoomIn = findViewById(R.id.clPinchZoomIn);
        clPinchZoomOut = findViewById(R.id.clPinchZoomOut);
        cl1FingerSwipeLeft = findViewById(R.id.cl1FingerSwipeLeft);
        cl1FingerSwipeUp = findViewById(R.id.cl1FingerSwipeUp);
        cl1FingerSwipeDown = findViewById(R.id.cl1FingerSwipeDown);
        clBarChart = findViewById(R.id.clBarChart);

    }

    private void setClickListeners() {
        clThreeFingerSwipeDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GestureDetectionActivity.class);
                intent.putExtra("pi0po1ofr2tfr3tfd4tfu5ofl6ofu7ofd8", ConstantsProvider.GESTURE_THREE_FINGER_DOWN);
                startActivity(intent);
            }
        });
        clThreeFingerSwipeUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GestureDetectionActivity.class);
                intent.putExtra("pi0po1ofr2tfr3tfd4tfu5ofl6ofu7ofd8", 5);
                startActivity(intent);
            }
        });
        cl2FingerSwipeRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GestureDetectionActivity.class);
                intent.putExtra("pi0po1ofr2tfr3tfd4tfu5ofl6ofu7ofd8", 3);
                startActivity(intent);
            }
        });
        cl1FingerSwipeRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GestureDetectionActivity.class);
                intent.putExtra("pi0po1ofr2tfr3tfd4tfu5ofl6ofu7ofd8", 2);
                startActivity(intent);
            }
        });
        cl1FingerSwipeLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GestureDetectionActivity.class);
                intent.putExtra("pi0po1ofr2tfr3tfd4tfu5ofl6ofu7ofd8", 6);
                startActivity(intent);
            }
        });
        cl1FingerSwipeUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GestureDetectionActivity.class);
                intent.putExtra("pi0po1ofr2tfr3tfd4tfu5ofl6ofu7ofd8", 7);
                startActivity(intent);
            }
        });
        cl1FingerSwipeDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GestureDetectionActivity.class);
                intent.putExtra("pi0po1ofr2tfr3tfd4tfu5ofl6ofu7ofd8", 8);
                startActivity(intent);
            }
        });
        clPinchZoomIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GestureDetectionActivity.class);
                intent.putExtra("pi0po1ofr2tfr3tfd4tfu5ofl6ofu7ofd8", 0);
                startActivity(intent);
            }
        });
        clPinchZoomOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GestureDetectionActivity.class);
                intent.putExtra("pi0po1ofr2tfr3tfd4tfu5ofl6ofu7ofd8", 1);
                startActivity(intent);
            }
        });
        clBarChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BarChartActivity.class);
                startActivity(intent);
            }
        });
    }


}