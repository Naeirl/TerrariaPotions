package com.example.terrariapotions.Remote;

import android.util.Log;

import com.example.terrariapotions.Model.Category;
import com.example.terrariapotions.Model.CategoryPotion;
import com.example.terrariapotions.Model.ChuckNoris;
import com.example.terrariapotions.Model.ImagePotion;
import com.example.terrariapotions.Model.Ingredient;
import com.example.terrariapotions.Model.Potion;
import com.example.terrariapotions.Model.PotionIngredient;
import com.example.terrariapotions.Repo.IResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChuckNorisRequest {
// this class is using callback and passing response to it
    public static final String baseURL = "https://raw.githubusercontent.com";

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
    public void getPotionsData(IResponse callback){
        Gson gson = new GsonBuilder()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RetrofitAPI client = retrofit.create(RetrofitAPI.class);

        Call<List<Potion>> call = client.getListOfPotions();

        call.enqueue(new Callback<List<Potion>>() {
            @Override
            public void onResponse(Call<List<Potion>> call, Response<List<Potion>> response) {
                Log.d("Response", response.body().toString());
                // here
                callback.getPotionsData(response.body());

            }
            @Override
            public void onFailure(Call<List<Potion>> call, Throwable t) {

            }
        });
    }

    public void getListOfCategories(IResponse callback){
        Gson gson = new GsonBuilder()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RetrofitAPI client = retrofit.create(RetrofitAPI.class);

        Call<List<Category>> call = client.getListOfCategories();

        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                Log.d("Response", response.body().toString());
                // here
                callback.getListOfCategories(response.body());
            }
            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {

            }
        });
    }

    public void getListOfCategoryPotions(IResponse callback){
        Gson gson = new GsonBuilder()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RetrofitAPI client = retrofit.create(RetrofitAPI.class);

        Call<List<CategoryPotion>> call = client.getListOfCategoryPotions();

        call.enqueue(new Callback<List<CategoryPotion>>() {
            @Override
            public void onResponse(Call<List<CategoryPotion>> call, Response<List<CategoryPotion>> response) {
                Log.d("Response", response.body().toString());
                // here
                callback.getListOfCategoryPotions(response.body());
            }
            @Override
            public void onFailure(Call<List<CategoryPotion>> call, Throwable t) {

            }
        });
    }

    public void getListOfImagePotions(IResponse callback){
        Gson gson = new GsonBuilder()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RetrofitAPI client = retrofit.create(RetrofitAPI.class);

        Call<List<ImagePotion>> call = client.getListOfImagePotions();

        call.enqueue(new Callback<List<ImagePotion>>() {
            @Override
            public void onResponse(Call<List<ImagePotion>> call, Response<List<ImagePotion>> response) {
                Log.d("Response", response.body().toString());
                // here
                callback.getListOfImagePotions(response.body());
            }
            @Override
            public void onFailure(Call<List<ImagePotion>> call, Throwable t) {

            }
        });
    }

    public void getListOfIngredients(IResponse callback){
        Gson gson = new GsonBuilder()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RetrofitAPI client = retrofit.create(RetrofitAPI.class);

        Call<List<Ingredient>> call = client.getListOfIngredients();

        call.enqueue(new Callback<List<Ingredient>>() {
            @Override
            public void onResponse(Call<List<Ingredient>> call, Response<List<Ingredient>> response) {
                Log.d("Response", response.body().toString());
                // here
                callback.getListOfIngredients(response.body());
            }
            @Override
            public void onFailure(Call<List<Ingredient>> call, Throwable t) {

            }
        });
    }

    public void getListOfPotionIngredients(IResponse callback){
        Gson gson = new GsonBuilder()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RetrofitAPI client = retrofit.create(RetrofitAPI.class);

        Call<List<PotionIngredient>> call = client.getListOfPotionIngredients();

        call.enqueue(new Callback<List<PotionIngredient>>() {
            @Override
            public void onResponse(Call<List<PotionIngredient>> call, Response<List<PotionIngredient>> response) {
                Log.d("Response", response.body().toString());
                // here
                callback.getListOfPotionIngredients(response.body());
            }
            @Override
            public void onFailure(Call<List<PotionIngredient>> call, Throwable t) {

            }
        });
    }
}
