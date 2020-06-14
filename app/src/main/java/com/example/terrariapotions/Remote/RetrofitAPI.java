package com.example.terrariapotions.Remote;

import com.example.terrariapotions.Model.Category;
import com.example.terrariapotions.Model.CategoryPotion;
import com.example.terrariapotions.Model.ChuckNoris;
import com.example.terrariapotions.Model.ImagePotion;
import com.example.terrariapotions.Model.Ingredient;
import com.example.terrariapotions.Model.Potion;
import com.example.terrariapotions.Model.PotionIngredient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPI {

    @GET("/jokes/random")
    Call<ChuckNoris> getChuckNorisQuote();

    @GET("/Naeirl/FakeJson/master/Category")
    Call<List<Category>> getListOfCategories();

    @GET("/Naeirl/FakeJson/master/CategoryPotion")
    Call<List<CategoryPotion>> getListOfCategoryPotions();

    @GET("/Naeirl/FakeJson/master/ImagePotion")
    Call<List<ImagePotion>> getListOfImagePotions();

    @GET("/Naeirl/FakeJson/master/Ingredient")
    Call<List<Ingredient>> getListOfIngredients();

    @GET("/Naeirl/FakeJson/master/Potions")
    Call<List<Potion>> getListOfPotions();

    @GET("/Naeirl/FakeJson/master/PotionIngredient")
    Call<List<PotionIngredient>> getListOfPotionIngredients();

}
