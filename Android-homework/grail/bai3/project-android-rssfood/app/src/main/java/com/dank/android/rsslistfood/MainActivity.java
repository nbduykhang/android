package com.dank.android.rsslistfood;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.dank.android.rsslistfood.adapter.FoodAdapter;
import com.dank.android.rsslistfood.model.FoodModel;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvFood;
    ArrayList<FoodModel> lstFood;
    FoodAdapter foodAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        new ReadRSS().execute("http://www.geniuskitchen.com/rss");
        addEvents();
    }

    private void addEvents() {
        lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //click -> run other Activity
                /*Intent intent = new Intent(MainActivity.this,FoodDetailActivity.class);
                intent.putExtra("LINKFOOD",lstFood.get(position).getLink());
                startActivity(intent);*/

                //click -> run alertdialog after click more info -> run other Activity
                showAleartDialog(position);
            }
        });
    }

    private void addControls() {
        lvFood = (ListView) findViewById(R.id.lvFood);
        lstFood = new ArrayList<>();
        foodAdapter = new FoodAdapter(MainActivity.this,R.layout.item,lstFood);
        lvFood.setAdapter(foodAdapter);
    }

    private void showAleartDialog(int i) {
        final int position = i;
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int choice) {

                switch (choice) {
                    case DialogInterface.BUTTON_NEUTRAL:
                        Intent intent = new Intent(MainActivity.this,FoodDetailActivity.class);
                        intent.putExtra("LINKFOOD",lstFood.get(position).getLink());
                        startActivity(intent);
                        break;
                }
            }
        };

        // create a WebView with the current stats
        WebView webView = new WebView(MainActivity.this);
        webView.loadData(lstFood.get(i).getDescription(), "text/html", "utf-8");

        // display the WebView in an AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(lstFood.get(i).getTitle())
                .setView(webView)
                .setNeutralButton("More Info", dialogClickListener)
                .show();

    }

    private class ReadRSS extends AsyncTask<String,Void,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            XMLDOMParser parser = new XMLDOMParser();
            Document document = parser.getDocument(s);
            NodeList nodeList = document.getElementsByTagName("item");
            String title="";
            String description="";
            String pubDate="";
            String link="";
            for (int i=0; i<nodeList.getLength();i++){
                Element element = (Element) nodeList.item(i);
                title=parser.getValue(element,"title");
                description=parser.getValue(element,"description");
                pubDate=parser.getValue(element,"pubDate");
                link=parser.getValue(element,"link");
                lstFood.add(new FoodModel(title,link,description,pubDate));
            }
            foodAdapter.notifyDataSetChanged();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder content= new StringBuilder();
            try{
                URL url=new URL(strings[0]);
                InputStreamReader isr=new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader br=new BufferedReader(isr);
                String line="";
                while((line=br.readLine())!=null){
                    content.append(line);
                }
                br.close();
            } catch (Exception ex) {
                Log.e("Loi", ex.toString());
            }
            return content.toString();
        }
    }
}
