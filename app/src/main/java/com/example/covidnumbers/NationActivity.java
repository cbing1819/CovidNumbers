package com.example.covidnumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class NationActivity extends AppCompatActivity {

    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nation);

        ListView listView = findViewById(R.id.my_list);
        List<String> mylist = new ArrayList();
        mylist.add("ALA Aland Islands"); mylist.add("Afghanistan");
        mylist.add("Albania");mylist.add("Algeria");
        mylist.add("American Samoa");mylist.add("Andorra");
        mylist.add("Angola");mylist.add("Anguilla");
        mylist.add("Antarctica");mylist.add("Antigua and Barbuda");
        mylist.add("Argentina");mylist.add("Armenia");
        mylist.add("Aruba");mylist.add("Australia");
        mylist.add("Austria");mylist.add("Azerbaijan");
        mylist.add("Bahamas");mylist.add("Bahrain");
        mylist.add("Bangladesh");mylist.add("Barbados");
        mylist.add("Belarus");mylist.add("Belgium");
        mylist.add("Belize");mylist.add("Benin");
        mylist.add("Bermuda");mylist.add("Bhutan");
        mylist.add()

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mylist);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                openSelectActivity();
            }
        });
    }

    public void openSelectActivity() {
        Intent intent = new Intent(this, SelectActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.my_menu, menu);
        MenuItem  menuItem = menu.findItem(R.id.search_icon);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search Here!");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                arrayAdapter.getFilter().filter(s);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
