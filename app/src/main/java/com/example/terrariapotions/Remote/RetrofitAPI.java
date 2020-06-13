package com.example.terrariapotions.Remote;

import com.example.terrariapotions.Model.ChuckNoris;
import com.example.terrariapotions.Model.Potion;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPI {

    @GET("/jokes/random")
    Call<ChuckNoris> getChuckNorisQuote();

    @GET("")
    Call<List<Potion>> getListOfPotions();

}
