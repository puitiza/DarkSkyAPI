package com.example.apuitiza.darkskyapi.Services;

import android.util.Log;

import com.example.apuitiza.darkskyapi.MainActivity;
import com.example.apuitiza.darkskyapi.Models.Clima;
import com.example.apuitiza.darkskyapi.Models.Currently;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClimaServiceProvider {

    private static  final String TAG = ClimaServiceProvider.class.getSimpleName();
    private Retrofit retrofit;
    private static final String BASE_URL = "https://api.darksky.net/forecast/e80b2218b6e487a5c034ffa09343f10c/";

    private Retrofit getRetrofit(){
        if(this.retrofit == null ){
            this.retrofit =  new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public void getWeather(double lat, double lng){
        ClimaService service = getRetrofit().create(ClimaService.class);
        Call<Clima> climaData = service.getClima(lat,lng);
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
