package edu.temple.spinnercolor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.logging.Logger;

public class PaletteActivity extends AppCompatActivity implements PaletteFragment.ChangeColorInterface {

    CanvasFragment receiver;
    boolean twoPanes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        twoPanes = (findViewById(R.id.canvas_frag)!= null);
        receiver = new CanvasFragment();

        PaletteFragment sender = new PaletteFragment();
        getFragmentManager()
                .beginTransaction()
                .add(R.id.palette_frag, sender)
                .commit();

        receiver = new CanvasFragment();
        //if canvas fragment exists show the fragment
        if(twoPanes){
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.canvas_frag, receiver)
                    .commit();
        }
    }


    private void fragTransition(){
        Logger log = Logger.getAnonymousLogger();
        log.info("fragTransition() method executed");
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.palette_frag, receiver)
                .addToBackStack(null)
                .commit();
        getFragmentManager().executePendingTransactions();
    }

    @Override
    public void ColorClicked(String color) {
        if (!twoPanes){
            fragTransition();
        }
        receiver.changeColor(color);
        getFragmentManager().executePendingTransactions();
    }
}
