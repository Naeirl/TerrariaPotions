package com.example.terrariapotions.Repo;

import com.example.terrariapotions.Model.Category;
import com.example.terrariapotions.Model.CategoryPotion;
import com.example.terrariapotions.Model.ChuckNoris;
import com.example.terrariapotions.Model.ImagePotion;
import com.example.terrariapotions.Model.Ingredient;
import com.example.terrariapotions.Model.Potion;
import com.example.terrariapotions.Model.PotionIngredient;

import java.util.List;

//Callback to pass response from request class to repository
public interface IResponse {

   void getResponse(ChuckNoris chuckNoris);



   void getListOfCategories(List<Category> categories);
   void getListOfCategoryPotions(List<CategoryPotion> categoryPotions);
   void getListOfImagePotions(List<ImagePotion> imagePotions);
   void getListOfIngredients(List<Ingredient> ingredients);
   void getPotionsData(List<Potion> potions);
   void getListOfPotionIngredients(List<PotionIngredient> potionIngredients);
}
