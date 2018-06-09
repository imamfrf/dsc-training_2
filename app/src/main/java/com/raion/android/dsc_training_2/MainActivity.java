package com.raion.android.dsc_training_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TypefaceSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public TextView tv_temperature;
    public RecyclerView recyclerView;
    public RecyclerView.Adapter adapter;
    public List<List_Item> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set action bar title
        getSupportActionBar().setTitle("WEADIFY");

        tv_temperature =  findViewById(R.id.tv_temperature);
        tv_temperature.setText("13" + (char) 0x00B0);

        //inisialisasi recyclerView
        recyclerView = findViewById(R.id.recyclerView_last_search);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //instansiasi objek list item
        listItems = new ArrayList<List_Item>();
        listItems.add(new List_Item("London, United Kingdom", "14", R.drawable.clouds));
        listItems.add(new List_Item("Stockholm, Sweden", "8", R.drawable.sun));
        listItems.add(new List_Item("San Fransisco, United States", "19", R.drawable.rain));

        //instansiasi adapter, set ke recyclerView
        adapter = new myAdapter(listItems, this);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
