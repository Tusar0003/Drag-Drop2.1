package com.example.no0ne.dragdrop21;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    float x,y = 0.0f;
    boolean moving = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.imageView);

        image.setOnTouchListener(touchListener);
    }


    View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    moving = true;
                    break;
                case MotionEvent.ACTION_MOVE:
                    if (moving) {
                        x = event.getRawX() - image.getWidth() / 2;
                        y = event.getRawY() - image.getHeight() * 3 / 2;

                        image.setX(x);
                        image.setY(y);
                    }

                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }

            return true;
        }
    };
}
