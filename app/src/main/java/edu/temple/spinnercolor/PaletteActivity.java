package edu.temple.spinnercolor;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class PaletteActivity extends AppCompatActivity implements PalleteFragment.ChangeColorInterface {

    PalleteFragment palletefrag;
    NavFragment navfrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        palletefrag = new PalleteFragment();
        navfrag = new NavFragment();

        addFragment(palletefrag, R.id.pallete_frag);
        addFragment(navfrag, R.id.nav_frag);

    }

    private void addFragment (Fragment fragment, int containerId){
        getFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment)
                .commit();
    }

    @Override
    public void ColorClicked(String color) {
        navfrag.changeColor(color);
    }
}
