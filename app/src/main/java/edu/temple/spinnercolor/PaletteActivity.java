package edu.temple.spinnercolor;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class PaletteActivity extends AppCompatActivity implements PaletteFragment.ChangeColorInterface {


    CanvasFragment receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        receiver = new CanvasFragment();


        addFragment(new PaletteFragment(), R.id.palette_frag);
        addFragment(receiver, R.id.canvas_frag);

    }

    private void addFragment (Fragment fragment, int containerId){
        getFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment)
                .commit();
    }

    @Override
    public void ColorClicked(String color) {
        receiver.changeColor(color);
    }
}
