package com.jacup101.weatherapi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class WeatherActivity extends AppCompatActivity {

    private ArrayList<WeatherTime> forecast;
    private TextView cityText;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);



        Intent intent = getIntent();
        String jsonStr = intent.getStringExtra(String.valueOf(R.string.json_key));

        forecast = new ArrayList<WeatherTime>();
        cityText = findViewById(R.id.cityText);
        recyclerView = findViewById(R.id.recyclerView_weather);

        Log.d("json_val",jsonStr);
        try {
            JSONObject json = new JSONObject(jsonStr);
            //Set city title
            JSONObject city = json.getJSONObject("city");
            cityText.setText(city.getString("name") + ", " + city.getString("country"));
            JSONArray list = json.getJSONArray("list");
            for(int i = 0; i < list.length();i++) {
                JSONObject curr = list.getJSONObject(i);
                String dt = curr.getString("dt_txt");
                String date = dt.substring(0,dt.indexOf(' '));
                String time = dt.substring(dt.indexOf(' ')+1,dt.length());
                JSONObject main = curr.getJSONObject("main");
                String temp = Double.toString(main.getDouble("feels_like"));
                String desc = curr.getJSONArray("weather").getJSONObject(0).getString("description");
                WeatherTime weatherTime = new WeatherTime(date,time,desc,temp + "F");
                forecast.add(weatherTime);
            }
            WeatherTimeAdapter adapter = new WeatherTimeAdapter(forecast);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

        } catch (JSONException e) {
            Log.e("json_error","error");
            e.printStackTrace();
        }
    }
}
