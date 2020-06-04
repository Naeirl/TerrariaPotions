package com.example.terrariapotions.Remote;

import android.util.Log;

import com.example.terrariapotions.Model.ChuckNoris;
import com.example.terrariapotions.Repo.IResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChuckNorisRequest {
// this class is using callback and passing response to it
    public void getChuckNorisJoke(IResponse callback){


        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd' 'HH:mm:ss")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.chucknorris.io")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RetrofitAPI client = retrofit.create(RetrofitAPI.class);

        Call<ChuckNoris> call = client.getChuckNorisQuote();

        call.enqueue(new Callback<ChuckNoris>() {
            @Override
            public void onResponse(Call<ChuckNoris> call, Response<ChuckNoris> response) {
                Log.d("Response", response.body().toString());
                // here
                callback.getResponse(response.body());
            }

            @Override
            public void onFailure(Call<ChuckNoris> call, Throwable t) {
                Log.d("fail", t.getMessage());
            }
        });
    }
}
