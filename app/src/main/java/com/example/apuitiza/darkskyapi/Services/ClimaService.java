package com.example.apuitiza.darkskyapi.Services;

import com.example.apuitiza.darkskyapi.Models.Clima;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ClimaService {
    @GET(".")
    Call<Clima> getClima();
}
