package com.example.finalpredprof.grid;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.finalpredprof.R;

import java.util.ArrayList;

public class GridViewAdapter extends ArrayAdapter<ItemModel> {

    public GridViewAdapter(@NonNull Context context, ArrayList<ItemModel> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;
        if (listitemView == null) {

            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.row_item, parent, false);
        }

        ItemModel courseModel = getItem(position);
        TextView courseTV = listitemView.findViewById(R.id.item_text);

        courseTV.setText(courseModel.getText());
        listitemView.setBackgroundColor(courseModel.getBackgroundColor());
        return listitemView;
    }
}