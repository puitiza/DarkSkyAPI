package com.example.apuitiza.darkskyapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.apuitiza.darkskyapi.Models.Clima;
import com.example.apuitiza.darkskyapi.Models.Currently;
import com.example.apuitiza.darkskyapi.Services.ClimaService;
import com.example.apuitiza.darkskyapi.Services.ClimaServiceProvider;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static  final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestClimaActual(-12.1101715,-77.0497429);

    }

    private void requestClimaActual(double lat, double lng) {
        ClimaServiceProvider clima = new ClimaServiceProvider();
        clima.getWeather(lat,lng);
    }
}
