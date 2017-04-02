package edu.temple.spinnercolor;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class PaletteActivity extends AppCompatActivity implements PaletteFragment.ChangeColorInterface {

    CanvasFragment receiver;
    //boolean twoPanes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        receiver = new CanvasFragment();

        //if canvas fragment xml exists, show both fragments
        if (findViewById(R.id.canvas_frag)!=null) {
            addFragment(new PaletteFragment(), R.id.palette_frag);
            addFragment(receiver, R.id.canvas_frag); }
        else {
            addFragment(new PaletteFragment(), R.id.palette_frag);
        }

    }

    private void addFragment (Fragment fragment, int containerId){
        getFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment)
                .commit();
    }

    private void fragTransition(Fragment fragment, int containerId){
        getFragmentManager()
                .beginTransaction()
                .add(containerId, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void ColorClicked(String color) {
        if (findViewById(R.id.canvas_frag)!=null) {
            receiver.changeColor(color);
        } else { //if portrait mode
            fragTransition(receiver, R.id.palette_frag);
            getFragmentManager().executePendingTransactions();
            receiver.changeColor(color);
        }
    }
}
