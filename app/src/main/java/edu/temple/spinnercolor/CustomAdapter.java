package edu.temple.spinnercolor;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Frank on 2/8/2017.
 */

public class CustomAdapter extends BaseAdapter {

    Context context;
    String[] colors;
    String[] colorLabels;

    public CustomAdapter(Context c, String[] colors, String[] colorLabels) {
        this.context = c;
        this.colors = colors;
        this.colorLabels = colorLabels;
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int position) {
        return colors[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView tv = new TextView(context);// must provide context

        //set its value to be object
        tv.setText(colorLabels[position]);
        tv.setBackgroundColor(Color.parseColor(colors[position]));
        //tv.setBackgroundColor(Integer.parseInt(colors[position]));
        return tv;
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent) {
       // View v = super.getView(position, convertView, parent);

        TextView tv = new TextView(context);
        tv.setText(colors[position]);
        tv.setBackgroundColor(Color.parseColor(colors[position]));
        return tv;
    }
}
