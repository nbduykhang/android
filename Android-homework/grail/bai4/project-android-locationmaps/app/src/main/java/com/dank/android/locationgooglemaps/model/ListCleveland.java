package com.dank.android.locationgooglemaps.model;

import com.dank.android.locationgooglemaps.R;

import java.util.ArrayList;

public class ListCleveland {
    public static ArrayList<ClevelandItem> getList(){
        ArrayList<ClevelandItem> lst = new ArrayList<>();
        lst.add(new ClevelandItem("Cleveland Tower City","https://www.towercitycenter.com/", R.drawable.cleveland_tower_city,41.497462, -81.694394));
        lst.add(new ClevelandItem("Browns Football Field","http://firstenergystadium.com/", R.drawable.browns_cleveland_stadium,41.506546, -81.699893));
        lst.add(new ClevelandItem("Cleveland State University","http://www.csuohio.edu/", R.drawable.cleveland_state_university,41.502219, -81.675064));
        lst.add(new ClevelandItem("Playhouse Square","http://www.playhousesquare.org/", R.drawable.playhouse_square,41.501284, -81.680797));
        lst.add(new ClevelandItem("Art Museum","http://www.clevelandart.org/", R.drawable.cleveland_art_museum,41.508930, -81.611959));
        return lst;
    }
}
