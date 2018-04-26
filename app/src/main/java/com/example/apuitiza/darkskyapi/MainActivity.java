package com.example.apuitiza.darkskyapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.apuitiza.darkskyapi.Models.Clima;
import com.example.apuitiza.darkskyapi.Models.Currently;
import com.example.apuitiza.darkskyapi.Services.ClimaService;

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

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.darksky.net/forecast/e80b2218b6e487a5c034ffa09343f10c/-12.1101715,-77.0497429/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ClimaService service = retrofit.create(ClimaService.class);
        Call<Clima> climaData = service.getClima();
        climaData.enqueue(new Callback<Clima>() {
            @Override
            public void onResponse(Call<Clima> call, Response<Clima> response) {
                Currently currently = response.body().getCurrently();
                Log.e(TAG,"Temperatura = "+currently.getTemperature());
            }

            @Override
            public void onFailure(Call<Clima> call, Throwable t) {
                Log.e(TAG,"No esta disponible la información");

            }
        });
    }
}
