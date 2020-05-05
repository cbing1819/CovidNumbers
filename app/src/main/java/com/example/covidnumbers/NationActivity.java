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

/**
 * holds SearchView. Very neat, innit?
 */
public class NationActivity extends AppCompatActivity {
    /**
     * the String for the name of the country selected by users.
     */
    String selected;

    /**
     * this adapter provides views for an AdapterView
     */
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nation);

        ListView listView = findViewById(R.id.my_list);
        final List<String> mylist = new ArrayList();

        //Yes, this is all copy-and-pasted. I know I can do it using "/countries" endpoint and a loop.
        // However, I ain't deleting it. It is like my child! Ain't no one's gonna be deleting it! ヽ(ಠ_ಠ)ノ

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
        mylist.add("Bolivia");mylist.add("Bosnia and Herzegovina");
        mylist.add("Botswana");mylist.add("Bouvet Island");
        mylist.add("Brazil");mylist.add("British Indian Ocean Territory");
        mylist.add("British Virgin Islands");mylist.add("Brunei Darussalam");
        mylist.add("Bulgaria");mylist.add("Burkina Faso");
        mylist.add("Burundi");mylist.add("Cambodia");
        mylist.add("Cameroon");mylist.add("Canada");
        mylist.add("Cape Verde");mylist.add("Cayman Islands");
        mylist.add("Central African Republic");mylist.add("Chad");
        mylist.add("Chile");mylist.add("China");
        mylist.add("Christmas Island");mylist.add("Cocos (Keeling) Islands");
        mylist.add("Colombia");mylist.add("Comoros");
        mylist.add("Congo (Brazzaville)");mylist.add("Congo (Kinshasa)");
        mylist.add("Cook Islands");mylist.add("Costa Rica");
        mylist.add("Croatia");mylist.add("Cuba");
        mylist.add("Cyprus");mylist.add("Czech Republic");
        mylist.add("Côte d'Ivoire");mylist.add("Denmark");
        mylist.add("Djibouti");mylist.add("Dominica");
        mylist.add("Dominican Republic");mylist.add("Ecuador");
        mylist.add("Egypt");mylist.add("El Salvador");
        mylist.add("Equatorial Guinea");mylist.add("Eritrea");
        mylist.add("Estonia");mylist.add("Ethiopia");
        mylist.add("Falkland Islands (Malvinas)");mylist.add("Faroe Islands");
        mylist.add("Fiji");mylist.add("Finland");
        mylist.add("France");mylist.add("French Guiana");
        mylist.add("French Polynesia");mylist.add("French Southern Territories");
        mylist.add("Gabon");mylist.add("Gambia");
        mylist.add("Georgia");mylist.add("Germany");
        mylist.add("Ghana");mylist.add("Gibraltar");
        mylist.add("Greece");mylist.add("Greenland");
        mylist.add("Grenada");mylist.add("Guadeloupe");
        mylist.add("Guam");mylist.add("Guatemala");
        mylist.add("Guernsey");mylist.add("Guinea");
        mylist.add("Guyana");mylist.add("Guinea-Bissau");
        mylist.add("Haiti");mylist.add("Heard and Mcdonald Islands");
        mylist.add("Holy See (Vatican City State)");mylist.add("Honduras");
        mylist.add("Hong Kong, SAR China");mylist.add("Hungary");
        mylist.add("Iceland");mylist.add("India");
        mylist.add("Indonesia");mylist.add("Iran, Islamic Republic of");
        mylist.add("Iraq");mylist.add("Ireland");
        mylist.add("Isle of Man");mylist.add("Israel");
        mylist.add("Italy");mylist.add("Jamaica");
        mylist.add("Japan");mylist.add("Jersey");
        mylist.add("Jordan");mylist.add("Kazakhstan");
        mylist.add("Kenya");mylist.add("Kiribati");
        mylist.add("Korea (North)");mylist.add("Korea (South)");
        mylist.add("Kuwait");mylist.add("Kyrgyzstan");
        mylist.add("Lao PDR");mylist.add("Latvia");
        mylist.add("Lebanon");mylist.add("Lesotho");
        mylist.add("Liberia");mylist.add("Libya");
        mylist.add("Liechtenstein");mylist.add("Lithuania");
        mylist.add("Luxembourg");mylist.add("Macao, SAR China");
        mylist.add("Macedonia, Republic of");mylist.add("Madagascar");
        mylist.add("Malawi");mylist.add("Malaysia");
        mylist.add("Maldives");mylist.add("Mali");
        mylist.add("Malta");mylist.add("Marshall Islands");
        mylist.add("Martinique");mylist.add("Mauritania");
        mylist.add("Mauritius");mylist.add("Mayotte");
        mylist.add("Mexico");mylist.add("Micronesia, Federated States of");
        mylist.add("Moldova");mylist.add("Monaco");
        mylist.add("Mongolia");mylist.add("Montenegro");
        mylist.add("Montserrat");mylist.add("Morocco");
        mylist.add("Mozambique");mylist.add("Myanmar");
        mylist.add("Namibia");mylist.add("Nauru");
        mylist.add("Nepal");mylist.add("Netherlands");
        mylist.add("Netherlands Antilles");mylist.add("New Caledonia");
        mylist.add("New Zealand");mylist.add("Nicaragua");
        mylist.add("Niger");mylist.add("Nigeria");
        mylist.add("Niue");mylist.add("Norfolk Island");
        mylist.add("Northern Mariana Islands");mylist.add("Norway");
        mylist.add("Oman");mylist.add("Pakistan");
        mylist.add("Palau");mylist.add("Palestinian Territory");
        mylist.add("Panama");mylist.add("Papua New Guinea");
        mylist.add("Paraguay");mylist.add("Peru");
        mylist.add("Philippines");mylist.add("Pitcairn");
        mylist.add("Poland");mylist.add("Portugal");
        mylist.add("Puerto Rico");mylist.add("Qatar");
        mylist.add("Republic of Kosovo");mylist.add("Romania");
        mylist.add("Russian Federation");mylist.add("Rwanda");
        mylist.add("Réunion");mylist.add("Saint Helena");
        mylist.add("Saint Kitts and Nevis");mylist.add("Saint Lucia");
        mylist.add("Saint Pierre and Miquelon");mylist.add("Saint Vincent and Grenadines");
        mylist.add("Saint-Barthélemy");mylist.add("Saint-Martin (French part)");
        mylist.add("Samoa");mylist.add("San Marino");
        mylist.add("Sao Tome and Principe");mylist.add("Saudi Arabia");
        mylist.add("Senegal");mylist.add("Serbia");
        mylist.add("Seychelles");mylist.add("Sierra Leone");
        mylist.add("Singapore");mylist.add("Slovakia");
        mylist.add("Slovenia");mylist.add("Solomon Islands");
        mylist.add("Somalia");mylist.add("South Africa");
        mylist.add("South Georgia and the South Sandwich Islands");mylist.add("South Sudan");
        mylist.add("Spain");mylist.add("Sri Lanka");
        mylist.add("Sudan");mylist.add("Suriname");
        mylist.add("Svalbard and Jan Mayen Islands");mylist.add("Swaziland");
        mylist.add("Sweden");mylist.add("Switzerland");
        mylist.add("Syrian Arab Republic (Syria)");mylist.add("Taiwan, Republic of China");
        mylist.add("Tajikistan");mylist.add("Tanzania, United Republic of");
        mylist.add("Thailand");mylist.add("Timor-Leste");
        mylist.add("Togo");mylist.add("Tonga");
        mylist.add("Trinidad and Tobago");mylist.add("Tunisia");
        mylist.add("Turkey");mylist.add("Turkmenistan");
        mylist.add("Turks and Caicos Islands");mylist.add("Tuvalu");
        mylist.add("US Minor Outlying Islands");mylist.add("Uganda");
        mylist.add("Ukraine");mylist.add("United Arab Emirates");
        mylist.add("United Kingdom");mylist.add("United States of America");
        mylist.add("Uruguay");mylist.add("Uzbekistan");
        mylist.add("Vanuatu");mylist.add("Viet Nam");
        mylist.add("Virgin Islands, US");mylist.add("Wallis and Futuna Islands");
        mylist.add("Western Sahara");mylist.add("Yemen");
        mylist.add("Zambia");mylist.add("Zimbabwe");

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mylist);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selected = (String) adapterView.getItemAtPosition(i);
                openSelectActivity();
            }
        });
    }

    /**
     * this opens select activity.
     */
    public void openSelectActivity() {
        Intent intent = new Intent(this, SelectActivity.class);
        intent.putExtra("Country", selected);
        startActivity(intent);
    }

    /**
     * this creates an option menu that holds all the items.
     * @param menu a menu.
     * @return whether it is successful.
     */
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
