package edu.temple.spinnercolor;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        RelativeLayout view = (RelativeLayout) findViewById(R.id.activity_canvas);

        //get the intent used to launch this instance of activity
        Intent received = getIntent();
        String dataReceived = received.getStringExtra("color_key");
        view.setBackgroundColor(Color.parseColor(dataReceived));
    }
}
