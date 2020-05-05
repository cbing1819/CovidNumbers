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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * this global activity shows CovidNumbers worldwide.
 */
public class GlobalActivity extends AppCompatActivity {

    public static final String TAG = "GlobalActivity";
    private TextView totalInfectedG;
    private TextView totalDeathG;
    private TextView dailyInfectedG;
    private TextView dailyDeathG;
    /**
     * the queue for volley.
     */
    private RequestQueue QUEUE;
    /**
     * url for api summary endpoint. urlSummary.
     */
    private String URLS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global);

        totalInfectedG = findViewById(R.id.totalIfectedGlobal);
        totalDeathG = findViewById(R.id.totalDeathGlobal);
        dailyInfectedG = findViewById(R.id.DailyInfectedGlobal);
        dailyDeathG = findViewById(R.id.DailyDeathGlobal);

        Button button = findViewById(R.id.gobackGlobal);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openMainActivity();
            }
        });

        QUEUE = Volley.newRequestQueue(this);
        URLS = "https://api.covid19api.com/summary";

        httpGET(URLS);

    }

    /**
     * this method gets the JSONObject from api and puts data into UI.
     * @param url the url used.
     */
    private void httpGET (String url) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url,null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("MyApp",response.toString());
                        try {
                            String tIG = "" + response.getJSONObject("Global").get("TotalConfirmed");
                            totalInfectedG.setText(tIG);
                            String tDG = "" + response.getJSONObject("Global").get("TotalDeaths");
                            totalDeathG.setText(tDG);
                            String dIG = "" + response.getJSONObject("Global").get("NewConfirmed");
                            dailyInfectedG.setText(dIG);
                            String dDG = "" + response.getJSONObject("Global").get("NewDeaths");
                            dailyDeathG.setText(dDG);
                        } catch (JSONException e) {
                            totalInfectedG.setText("Response is UYA");
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

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
