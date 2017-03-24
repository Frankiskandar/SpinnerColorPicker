package edu.temple.spinnercolor;


import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavFragment extends Fragment {

    View layout;
    public NavFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_nav, container, false);

        return layout;
    }

    public void changeColor(String color){
        layout.setBackgroundColor(Color.parseColor(color));
    }

}
