package edu.temple.spinnercolor;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PalleteFragment extends Fragment {

    ChangeColorInterface parent;

    public PalleteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View layout = inflater.inflate(R.layout.fragment_pallete, container, false);

        final GridView mygrid = (GridView) layout.findViewById(R.id.grid_view);
        final String[] myColors = {"White", "Red", "Yellow", "Green", "Blue", "Black", "Cyan", "Magenta", "Green", "Gray"};
        Resources res = getResources();
        String[] colorLabels = res.getStringArray(R.array.color_array);

        CustomAdapter adapter = new CustomAdapter(getContext() , myColors, colorLabels);
        mygrid.setAdapter(adapter);

        mygrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //mylayout.setBackgroundColor(Color.parseColor(((TextView) view).getText().toString()));
                ((ChangeColorInterface) getActivity()).ColorClicked(myColors[position]);
            }
        });

        return layout;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (activity instanceof ChangeColorInterface){
            parent = (ChangeColorInterface) activity;
        } else {
            throw new RuntimeException("Not Implemented");
        }
    }


    public interface ChangeColorInterface {
        void ColorClicked(String color);
    }

}