package com.example.apuitiza.darkskyapi.Services;

import com.example.apuitiza.darkskyapi.Models.Clima;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ClimaService {

    //Esta parte del get como le llega una extension de URL, en mi caso es
    //https://api.darksky.net/forecast/e80b2218b6e487a5c034ffa09343f10c/lat ,lng
    //se tiene que poner como debe consumir
    //el path coincide con el get
    @GET("{lat},{lng}")
    Call<Clima> getClima(@Path("lat") double lat, @Path("lng") double lng);
}
