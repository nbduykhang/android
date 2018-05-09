package com.dank.android.locationgooglemaps.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dank.android.locationgooglemaps.R;
import com.dank.android.locationgooglemaps.model.ClevelandItem;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomInfoAdapter implements GoogleMap.InfoWindowAdapter {
    Activity activity;
    ClevelandItem clevelandItem;
    public CustomInfoAdapter(Activity activity,ClevelandItem clevelandItem){
        this.activity=activity;
        this.clevelandItem=clevelandItem;
    }
    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        LayoutInflater inflater = this.activity.getLayoutInflater();
        View row = inflater.inflate(R.layout.item_map,null);
        TextView txtTenLocation = row.findViewById(R.id.txtTenLocation);
        ImageView imgHinhLocation = row.findViewById(R.id.imgHinhLocation);
        txtTenLocation.setText(clevelandItem.getTen());
        imgHinhLocation.setImageResource(clevelandItem.getHinh());

        return row;
    }
}
