package com.example.apuitiza.darkskyapi.Services;

import com.example.apuitiza.darkskyapi.Models.Clima;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ClimaService {
    @GET("{lat},{lng}")
    Call<Clima> getClima(@Path("lat") double lat, @Path("lng") double lng);
}
