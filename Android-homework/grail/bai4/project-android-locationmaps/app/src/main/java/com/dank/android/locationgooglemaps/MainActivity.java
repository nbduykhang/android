package com.dank.android.locationgooglemaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.dank.android.locationgooglemaps.model.ClevelandItem;
import com.dank.android.locationgooglemaps.model.ListCleveland;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvCleveland;
    ArrayList<ClevelandItem> lstCleveland;
    ArrayAdapter<ClevelandItem> clevelandAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        lvCleveland.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ClevelandItem cleveland = lstCleveland.get(position);
                Intent intent = new Intent(MainActivity.this,EventsActivity.class);
                intent.putExtra("LISTCLEVELAND",cleveland);
                startActivity(intent);
            }
        });
    }

    private void addControls() {
        lvCleveland = (ListView) findViewById(R.id.lvCleveland);
        lstCleveland = ListCleveland.getList();
        clevelandAdapter = new ArrayAdapter<ClevelandItem>(MainActivity.this,android.R.layout.simple_list_item_1,lstCleveland);
        lvCleveland.setAdapter(clevelandAdapter);
    }
}
