package com.dank.android.rsslistfood.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.dank.android.rsslistfood.R;
import com.dank.android.rsslistfood.model.FoodModel;

import java.util.List;

public class FoodAdapter extends ArrayAdapter<FoodModel> {
    Activity activity;
    int resource;
    List<FoodModel> objects;
    public FoodAdapter(@NonNull Activity activity, int resource, @NonNull List<FoodModel> objects) {
        super(activity, resource, objects);
        this.activity = activity;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = this.activity.getLayoutInflater();
        //Lấy giao diện 1 dòng
        View row = inflater.inflate(resource,null);
        //Đưa giao diện dữ liệu vừa lấy được vào view
        TextView txtTitle = (TextView) row.findViewById(R.id.txtTitle);
        TextView txtPubDate = (TextView) row.findViewById(R.id.txtPubDate);

        FoodModel food = this.objects.get(position);
        txtTitle.setText(food.getTitle());
        txtPubDate.setText(food.getPubDate());

        return row;
    }
}
