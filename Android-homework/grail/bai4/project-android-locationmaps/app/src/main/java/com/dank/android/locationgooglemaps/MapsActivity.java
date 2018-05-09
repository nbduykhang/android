package com.dank.android.locationgooglemaps;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.dank.android.locationgooglemaps.adapter.CustomInfoAdapter;
import com.dank.android.locationgooglemaps.model.ClevelandItem;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Intent intent = getIntent();
        ClevelandItem clevelandItem = (ClevelandItem) intent.getSerializableExtra("CLEVELANDLIST");

        // Add a marker in Sydney and move the camera
        LatLng locate = new LatLng(clevelandItem.getViDo(), clevelandItem.getKinhDo());
        Marker marker=mMap.addMarker(new MarkerOptions().position(locate).title(clevelandItem.getTen()));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(locate,10));
        mMap.setInfoWindowAdapter(new CustomInfoAdapter(MapsActivity.this,clevelandItem));
        marker.showInfoWindow();
    }
}
