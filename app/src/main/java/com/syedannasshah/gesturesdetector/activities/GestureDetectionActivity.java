package com.syedannasshah.gesturesdetector.activities;

import android.app.Dialog;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.syedannasshah.gesturesdetector.R;
import com.syedannasshah.gesturesdetector.helper.ConstantsProvider;
import com.syedannasshah.gesturesdetector.helper.SimpleFingerGestures;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class GestureDetectionActivity extends AppCompatActivity {

    private int pi0po1ofr2tfr3tfd4tfu5ofl6ofu7ofd8 = 0;
    private TextView tvGestureTitle, tvPixelsUsed, tvTimeTaken;
    private ImageView ivViewToPerformGestures, ivGestureImage, ivBack, ivGestureImageToAnimate;

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_detection);


        initializeViews();

        setTitleOfActivity();

        setupGestureListener();

        setupClickListeners();

    }

    private void setupClickListeners() {
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void setupGestureListener() {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        DecimalFormat df = new DecimalFormat("#.##");
//        String formatted = df.format(number);

        SimpleFingerGestures sfg = new SimpleFingerGestures();
        sfg.setDebug(true);
        sfg.setConsumeTouchEvents(true);

        sfg.setOnFingerGestureListener(new SimpleFingerGestures.OnFingerGestureListener() {
            @Override
            public boolean onSwipeUp(int fingers, long gestureDuration, double gestDistDouble) {
                String gestureDistance = df.format(gestDistDouble);
                if (pi0po1ofr2tfr3tfd4tfu5ofl6ofu7ofd8 == ConstantsProvider.GESTURE_ONE_FINGER_UP
                        && fingers == 1) {

                    ConstantsProvider.GESTURE_ONE_FINGER_UP_BAR = (int) (gestureDuration / gestDistDouble);
                    sendRequestToAPI((int) gestureDuration, (int) gestDistDouble);
                    tvPixelsUsed.setText("Pixels Used : " + gestureDistance + " px");
                    tvTimeTaken.setText("Time Taken : " + gestureDuration + " ms ");
                } else if (pi0po1ofr2tfr3tfd4tfu5ofl6ofu7ofd8 == ConstantsProvider.GESTURE_THREE_FINGER_UP
                        && fingers == 3) {
                    ConstantsProvider.GESTURE_THREE_FINGER_UP_BAR = (int) (gestureDuration / gestDistDouble);
                    sendRequestToAPI((int) gestureDuration, (int) gestDistDouble);
                    tvPixelsUsed.setText("Pixels Used : " + gestureDistance + " px");
                    tvTimeTaken.setText("Time Taken : " + gestureDuration + " ms ");
//                    tvGesturesResult.setText("You swiped " + fingers + " fingers  UP " + gestureDuration + " milliseconds " + gestDistDouble + " pixels far");
                }
                return false;
            }

            @Override
            public boolean onSwipeDown(int fingers, long gestureDuration, double gestDistDouble) {
                String gestureDistance = df.format(gestDistDouble);
                if (pi0po1ofr2tfr3tfd4tfu5ofl6ofu7ofd8 == ConstantsProvider.GESTURE_ONE_FINGER_DOWN
                        && fingers == 1) {
                    ConstantsProvider.GESTURE_ONE_FINGER_DOWN_BAR = (int) (gestureDuration / gestDistDouble);
                    sendRequestToAPI((int) gestureDuration, (int) gestDistDouble);
                    tvPixelsUsed.setText("Pixels Used : " + gestureDistance + " px");
                    tvTimeTaken.setText("Time Taken : " + gestureDuration + " ms ");
//                    tvGesturesResult.setText("You swiped " + fingers + " fingers  down " + gestureDuration + " milliseconds " + gestDistDouble + " pixels far");
                } else if (pi0po1ofr2tfr3tfd4tfu5ofl6ofu7ofd8 == ConstantsProvider.GESTURE_THREE_FINGER_DOWN
                        && fingers == 3) {
                    ConstantsProvider.GESTURE_THREE_FINGER_DOWN_BAR = (int) (gestureDuration / gestDistDouble);
                    sendRequestToAPI((int) gestureDuration, (int) gestDistDouble);
                    tvPixelsUsed.setText("Pixels Used : " + gestureDistance + " px");
                    tvTimeTaken.setText("Time Taken : " + gestureDuration + " ms ");
//                    tvGesturesResult.setText("You swiped " + fingers + " fingers  down " + gestureDuration + " milliseconds " + gestDistDouble + " pixels far");
                }
                return false;
            }

            @Override
            public boolean onSwipeLeft(int fingers, long gestureDuration, double gestDistDouble) {
                String gestureDistance = df.format(gestDistDouble);
                if (pi0po1ofr2tfr3tfd4tfu5ofl6ofu7ofd8 == ConstantsProvider.GESTURE_ONE_FINGER_LEFT
                        && fingers == 1) {
                    ConstantsProvider.GESTURE_ONE_FINGER_LEFT_BAR = (int) (gestureDuration / gestDistDouble);
                    sendRequestToAPI((int) gestureDuration, (int) gestDistDouble);
                    tvPixelsUsed.setText("Pixels Used : " + gestureDistance + " px");
                    tvTimeTaken.setText("Time Taken : " + gestureDuration + " ms ");
//                    tvGesturesResult.setText("You swiped " + fingers + " fingers  left " + gestureDuration + " milliseconds " + gestDistDouble + " pixels far");
                }
                return false;
            }

            @Override
            public boolean onSwipeRight(int fingers, long gestureDuration, double gestDistDouble) {
                String gestureDistance = df.format(gestDistDouble);
                if (pi0po1ofr2tfr3tfd4tfu5ofl6ofu7ofd8 == ConstantsProvider.GESTURE_ONE_FINGER_RIGHT
                        && fingers == 1) {
                    ConstantsProvider.GESTURE_ONE_FINGER_RIGHT_BAR = (int) (gestureDuration / gestDistDouble);
                    sendRequestToAPI((int) gestureDuration, (int) gestDistDouble);
                    tvPixelsUsed.setText("Pixels Used : " + gestureDistance + " px");
                    tvTimeTaken.setText("Time Taken : " + gestureDuration + " ms ");
//                    tvGesturesResult.setText("You swiped " + fingers + " fingers  right " + gestureDuration + " milliseconds " + gestDistDouble + " pixels far");
                } else if (pi0po1ofr2tfr3tfd4tfu5ofl6ofu7ofd8 == ConstantsProvider.GESTURE_TWO_FINGER_RIGHT
                        && fingers == 2) {
                    ConstantsProvider.GESTURE_TWO_FINGER_RIGHT_BAR = (int) (gestureDuration / gestDistDouble);
                    sendRequestToAPI((int) gestureDuration, (int) gestDistDouble);
                    tvPixelsUsed.setText("Pixels Used : " + gestureDistance + " px");
                    tvTimeTaken.setText("Time Taken : " + gestureDuration + " ms ");
//                    tvGesturesResult.setText("You swiped " + fingers + " fingers  right " + gestureDuration + " milliseconds " + gestDistDouble + " pixels far");
                }
                return false;
            }

            @Override
            public boolean onPinch(int fingers, long gestureDuration, double gestDistDouble) {
                String gestureDistance = df.format(gestDistDouble);
                if (pi0po1ofr2tfr3tfd4tfu5ofl6ofu7ofd8 == ConstantsProvider.GESTURE_PINCH_ZOOM_IN) {

                    ConstantsProvider.GESTURE_PINCH_ZOOM_IN_BAR = (int) (gestureDuration / gestDistDouble);
                    sendRequestToAPI((int) gestureDuration, (int) gestDistDouble);

                    tvPixelsUsed.setText("Pixels Used : " + gestureDistance + " px");
                    tvTimeTaken.setText("Time Taken : " + gestureDuration + " ms ");
                }
                return false;
            }

            @Override
            public boolean onUnpinch(int fingers, long gestureDuration, double gestDistDouble) {
                String gestureDistance = df.format(gestDistDouble);
                if (pi0po1ofr2tfr3tfd4tfu5ofl6ofu7ofd8 == ConstantsProvider.GESTURE_PINCH_ZOOM_OUT) {


                    ConstantsProvider.GESTURE_PINCH_ZOOM_OUT_BAR = (int) (gestureDuration / gestDistDouble);


                    sendRequestToAPI((int) gestureDuration, (int) gestDistDouble);
                    tvPixelsUsed.setText("Pixels Used : " + gestureDistance + " px");
                    tvTimeTaken.setText("Time Taken : " + gestureDuration + " ms ");
                }
                return false;
            }

            @Override
            public boolean onDoubleTap(int fingers) {
                //double tap is not being used
                return false;
            }
        });


        ivViewToPerformGestures.setOnTouchListener(sfg);
    }

    private void initializeViews() {
        tvGestureTitle = findViewById(R.id.tvGestureTitle);
        ivBack = findViewById(R.id.ivBack);
        ivGestureImage = findViewById(R.id.ivGestureImage);
        ivViewToPerformGestures = (ImageView) findViewById(R.id.ivViewToPerformGestures);
        tvPixelsUsed = (TextView) findViewById(R.id.tvPixelsUsed);
        tvTimeTaken = (TextView) findViewById(R.id.tvTimeTaken);
        ivGestureImageToAnimate = (ImageView) findViewById(R.id.ivGestureImageToAnimate);

        animateImage();
    }

    private void animateImage() {


        // Set the initial visibility to "invisible" so that the image fades in
        ivGestureImageToAnimate.setVisibility(View.INVISIBLE);

        // Create the animation
        AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeIn.setDuration(1500);

        AlphaAnimation fadeOut = new AlphaAnimation(1.0f, 0.0f);
        fadeOut.setDuration(1500);

        // Set up the animation sequence
        AnimationSet animation = new AnimationSet(true);
        animation.addAnimation(fadeIn);
        animation.addAnimation(fadeOut);
        animation.setRepeatCount(10);

        // Set up a listener to set the visibility of the ImageView after the animation completes
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                counter = counter + 1;
                ivGestureImageToAnimate.setVisibility(View.INVISIBLE);
                if (counter < 10) {
                    // Start the animation
                    ivGestureImageToAnimate.startAnimation(animation);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        // Start the animation
        ivGestureImageToAnimate.startAnimation(animation);


    }

    private void setTitleOfActivity() {
        pi0po1ofr2tfr3tfd4tfu5ofl6ofu7ofd8 = getIntent().getIntExtra("pi0po1ofr2tfr3tfd4tfu5ofl6ofu7ofd8", 0);

        switch (pi0po1ofr2tfr3tfd4tfu5ofl6ofu7ofd8) {
            case ConstantsProvider.GESTURE_PINCH_ZOOM_IN:
                tvGestureTitle.setText("Pinch Zoom-In");
                ivGestureImage.setImageResource(R.drawable.ic_pinch_zoom_in);
                ivGestureImageToAnimate.setImageResource(R.drawable.ic_pinch_zoom_in_arrow);
                break;
            case ConstantsProvider.GESTURE_PINCH_ZOOM_OUT:
                tvGestureTitle.setText("Pinch Zoom-Out");
                ivGestureImage.setImageResource(R.drawable.ic_pinch_zoom_out);
                ivGestureImageToAnimate.setImageResource(R.drawable.ic_pinch_zoom_out_arrow);
                break;
            case ConstantsProvider.GESTURE_ONE_FINGER_RIGHT:
                tvGestureTitle.setText("1 Finger Right");
                ivGestureImage.setImageResource(R.drawable.ic_one_finger_right);
                ivGestureImageToAnimate.setImageResource(R.drawable.ic_one_finger_right_arrow);
                break;
            case ConstantsProvider.GESTURE_TWO_FINGER_RIGHT:
                tvGestureTitle.setText("2 Fingers Right");
                ivGestureImage.setImageResource(R.drawable.ic_two_fingers_right);
                ivGestureImageToAnimate.setImageResource(R.drawable.ic_two_fingers_right_arrow);
                break;
            case ConstantsProvider.GESTURE_THREE_FINGER_DOWN:
                tvGestureTitle.setText("3 Fingers Down");
                ivGestureImage.setImageResource(R.drawable.ic_three_fingers_down);
                ivGestureImageToAnimate.setImageResource(R.drawable.ic_three_fingers_down_arrow);
                break;
            case ConstantsProvider.GESTURE_THREE_FINGER_UP:
                tvGestureTitle.setText("3 Fingers Up");
                ivGestureImage.setImageResource(R.drawable.ic_three_fingers_up);
                ivGestureImageToAnimate.setImageResource(R.drawable.ic_three_fingers_up_arrow);
                break;
            case ConstantsProvider.GESTURE_ONE_FINGER_LEFT:
                tvGestureTitle.setText("1 Finger Left");
                ivGestureImage.setImageResource(R.drawable.ic_one_finger_left);
                ivGestureImageToAnimate.setImageResource(R.drawable.ic_one_finger_left_arrow);
                break;
            case ConstantsProvider.GESTURE_ONE_FINGER_UP:
                tvGestureTitle.setText("1 Finger Up");
                ivGestureImage.setImageResource(R.drawable.ic_one_finger_up);
                ivGestureImageToAnimate.setImageResource(R.drawable.ic_one_finger_up_arrow);
                break;
            case ConstantsProvider.GESTURE_ONE_FINGER_DOWN:
                tvGestureTitle.setText("1 Finger Down");
                ivGestureImage.setImageResource(R.drawable.ic_one_finger_down);
                ivGestureImageToAnimate.setImageResource(R.drawable.ic_one_finger_down_arrow);
                break;
        }
    }


    private void sendRequestToAPI(int value_one, int value_two) {

        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.layout_dialog_result);
        dialog.setCancelable(false);
        dialog.setTitle("Custom Dialog");

        CardView closeButton = dialog.findViewById(R.id.btnYES);
//        ProgressBar loadingProgressBar = dialog.findViewById(R.id.loadingProgressBar);
        TextView tvResponse = dialog.findViewById(R.id.detailsTV);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

        int val1by5 = value_one / 5;
        int val2by5 = value_two / 5;
        GraphView graph = (GraphView) dialog.findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(val1by5 * 0, val2by5 * 0),
                new DataPoint(val1by5 * 5, val2by5 * 5)
        });


        graph.addSeries(series);


        RequestQueue queue = Volley.newRequestQueue(GestureDetectionActivity.this);
//                String url = "http://192.168.82.195:5000";
        String url = "http://192.168.1.102:5000";


        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if (response.equals("0")) {
                            closeButton.setVisibility(View.VISIBLE);
                            tvResponse.setText("Normal");

                        } else if (response.equals("1")) {
                            closeButton.setVisibility(View.VISIBLE);
                            tvResponse.setText("Shaky");

                        } else {
                            closeButton.setVisibility(View.VISIBLE);
                            tvResponse.setText("" + response);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                loadingProgressBar.setVisibility(View.GONE);
                closeButton.setVisibility(View.VISIBLE);
                tvResponse.setText("Couldn't Send Request!");
//                Toast.makeText(MainActivity.this, "Couldn't Send Request!", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("value_two", String.valueOf(value_two));
                params.put("value_one", String.valueOf(value_one));

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }
        };

        queue.add(stringRequest);

    }
}
