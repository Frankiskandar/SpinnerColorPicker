package edu.temple.spinnercolor;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import static edu.temple.spinnercolor.R.id.grid_view;

public class PaletteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        final GridView mygrid = (GridView) findViewById(grid_view);
        final View mylayout = findViewById(R.id.activity_palette);

        final String[] myColors = {"White", "Red", "Yellow", "Green", "Blue", "Black", "Cyan", "Magenta", "Green", "Gray"};
        Resources res = getResources();
        String[] colorLabels = res.getStringArray(R.array.color_array);




        CustomAdapter adapter = new CustomAdapter(this,myColors,colorLabels);
        mygrid.setAdapter(adapter);

        mygrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //mylayout.setBackgroundColor(Color.parseColor(((TextView) view).getText().toString()));
                Intent intent = new Intent(PaletteActivity.this, CanvasActivity.class);

                //pass the data from this activity to canvas
                intent.putExtra("color_key", myColors[position]);
                startActivity(intent);
            }
        });


        /*
        mygrid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mylayout.setBackgroundColor(Color.parseColor(((TextView) view).getText().toString()));


                String color = parent.getSelectedItem().toString();
                    Intent intent = new Intent(PaletteActivity.this, CanvasActivity.class);

                    //pass the data from this activity to canvas
                    intent.putExtra("colorStuff", myColors[position]);
                    startActivity(intent);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        */
    }
}
