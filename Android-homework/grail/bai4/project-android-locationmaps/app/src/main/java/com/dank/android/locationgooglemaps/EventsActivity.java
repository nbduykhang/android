package com.dank.android.locationgooglemaps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dank.android.locationgooglemaps.model.ClevelandItem;

public class EventsActivity extends AppCompatActivity {
    TextView txtTen;
    ImageView imgHinh;
    Button btnMapit;
    Button btnMoreInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                ClevelandItem cleveland = (ClevelandItem) intent.getSerializableExtra("LISTCLEVELAND");
                Intent intent1 = new Intent(EventsActivity.this,InfoActivity.class);
                intent1.putExtra("DSCLEVELAND",cleveland);
                startActivity(intent1);
            }
        });

        btnMapit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                ClevelandItem cleveland = (ClevelandItem) intent.getSerializableExtra("LISTCLEVELAND");
                Intent intent2 = new Intent(EventsActivity.this,MapsActivity.class);
                intent2.putExtra("CLEVELANDLIST",cleveland);
                startActivity(intent2);
            }
        });
    }

    private void addControls() {
        txtTen = (TextView) findViewById(R.id.txtTen);
        imgHinh = (ImageView) findViewById(R.id.imgHinh);
        btnMapit = (Button) findViewById(R.id.btnMapIt);
        btnMoreInfo = (Button) findViewById(R.id.btnMoreInfo);

        Intent intent = getIntent();
        ClevelandItem cleveland = (ClevelandItem) intent.getSerializableExtra("LISTCLEVELAND");
        txtTen.setText(cleveland.getTen());
        imgHinh.setImageResource(cleveland.getHinh());
    }
}
