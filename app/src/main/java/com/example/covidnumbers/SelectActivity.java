package com.example.covidnumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * this shows CovidNumbers by selected nation. Very useful, innit?
 */
public class SelectActivity extends AppCompatActivity {

    /**
     * the country name stirng imported from NationActivity through intent.getStringExtra().
     */
    String sessionId;
    public static final String TAG = "SelectedActivity";
    private TextView totalInfectedN;
    private TextView totalDeathN;
    private TextView dailyInfectedN;
    private TextView dailyDeathN;
    /**
     * the queue for volley.
     */
    private RequestQueue QUEUE;
    private String URLS;
    /**
     * the barchart using MPAndroidChart. Cites https://github.com/PhilJay/MPAndroidChart.
     */
    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        Button button = findViewById(R.id.goBackSelect);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openMainActivity();
            }
        });

        Intent intent = getIntent();
        sessionId = intent.getStringExtra("Country");

        totalInfectedN = findViewById(R.id.totalInfectedSelect);
        totalDeathN = findViewById(R.id.totalDeathSelect);
        dailyInfectedN = findViewById(R.id.dailyInfectedSelect);
        dailyDeathN = findViewById(R.id.dailyDeathSelect);

        QUEUE = Volley.newRequestQueue(this);
        URLS = "https://api.covid19api.com/summary";

        getSupportActionBar().setTitle(sessionId);

        httpGET(URLS);

        generateGraph();

    }

    /**
     *  this method gets the JSONObject from api and puts data into UI.
     * @param url url used.
     */
    private void httpGET (String url) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray ja_data = response.getJSONArray("Countries");
                    int length = ja_data.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jObj = ja_data.getJSONObject(i);
                        if (jObj.get("Country").equals(sessionId)) {
                            String tIN = "" + jObj.get("TotalConfirmed");
                            totalInfectedN.setText(tIN);
                            String tDN = "" + jObj.get("TotalDeaths");
                            totalDeathN.setText(tDN);
                            String dIN = "" + jObj.get("NewConfirmed");
                            dailyInfectedN.setText(dIN);
                            String dDN = "" + jObj.get("NewDeaths");
                            dailyDeathN.setText(dDN);
                        }
                    }
                } catch (JSONException e) {
                    totalInfectedN.setText("No Response from Server");
                    totalDeathN.setText("No Response from Server");
                    dailyInfectedN.setText("No Response from Server");
                    dailyDeathN.setText("No Response from Server");
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("internet broken");
                System.out.println(error.getMessage() + "hi");
            }
        });
        QUEUE.add(request);
    }

    /**
     * this method generates graph for the past 7 days of confirmed cases. Did not cite from nowhere. Quite genius, innit?
     */
    public void generateGraph () {
        String url = "https://api.covid19api.com/country/" +sessionId + "/status/confirmed?from=2020-03-01T00:00:00Z&to=2999-04-01T00:00:00Z";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url ,null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d("MyApp",response.toString());
                try {
                    barChart = findViewById(R.id.selectedChart);
                    ArrayList<BarEntry> barEntries = new ArrayList<>();
                    ArrayList<String> theDates = new ArrayList<>();
                    int length = response.length();
                    int count = 0;
                    for (int i = length - 8; i < length - 1; i++) {
                        JSONObject jObj = response.getJSONObject(i);
                        int cases = (int) jObj.get("Cases");
                        barEntries.add(new BarEntry(cases, count));
                        String date = (String) jObj.get("Date");
                        theDates.add(date.substring(5, 10));
                        count++;
                    }
                    BarDataSet barDataSet = new BarDataSet(barEntries, "Dates");
                    BarData barData = new BarData(theDates, barDataSet);
                    barChart.setData(barData);
                } catch (JSONException e) {
                    totalInfectedN.setText("Response is UYA");
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("internet broken for chart");
                System.out.println(error.getMessage() + "hi");
            }
        });
        QUEUE.add(request);
    }

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
