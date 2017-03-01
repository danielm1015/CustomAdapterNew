package com.rabor.customadapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rabor.customadapter.data.Company;

import java.util.List;

/**
 * Created by leticia.rabor on 2/27/2017.
 */
public class CustomAdapter extends ArrayAdapter<Company> {

    // define variables
    private Context context;
    private List<Company> objects;

    public CustomAdapter(Context context, int resource, List<Company> objects) {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Company company = objects.get(position);

        // Inflating means reading the XML file that describes a layout
        // (or GUI element) and to create the actual objects that correspond to it,
        // and thus make the object visible within an Android app.

        // Passes an ID to get a handle on a system level service
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.listview_header_row, null);

        ImageView image = (ImageView) view.findViewById(R.id.logoImageView);
        image.setImageResource(company.imageResource);

        TextView nameTV = (TextView) view.findViewById(R.id.nameTV);
        nameTV.setText(company.companyName);

        return view;
    }
}
