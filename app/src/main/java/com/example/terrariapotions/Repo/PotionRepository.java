package com.example.terrariapotions.Repo;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.terrariapotions.Model.Category;
import com.example.terrariapotions.Model.CategoryPotion;
import com.example.terrariapotions.Model.ChuckNoris;
import com.example.terrariapotions.Model.ImagePotion;
import com.example.terrariapotions.Model.Ingredient;
import com.example.terrariapotions.Model.Potion;
import com.example.terrariapotions.Model.PotionDAO;
import com.example.terrariapotions.Model.PotionDatabase;
import com.example.terrariapotions.Model.PotionIngredient;

import java.util.List;

public class PotionRepository implements IResponse {

    private PotionDAO potionDAO;
    private PotionDatabase db;
    private static PotionRepository INSTANCE;
    private LiveData<List<Potion>> potions;
    private LiveData<List<CategoryPotion>> categoryPotions;

    private PotionRepository(Application application) {
        db = PotionDatabase.getDatabase(application);
        potionDAO = db.getPotionDAO();
        potions = potionDAO.getPotions();
//        categoryPotions = potionDAO.getCategoryPotions();
    }

    public static PotionRepository getInstance(Application application) {
        if (INSTANCE == null) {
            INSTANCE = new PotionRepository(application);
        }
        return INSTANCE;
    }

    public LiveData<List<Potion>> getAllPotion() {
        return potions;
    }
    public LiveData<List<CategoryPotion>> getAllCategoryPotions(){
        return categoryPotions;
    }

    public void insertPotion(Potion potion) {
        PotionDatabase.databaseWriteExecutor.execute(()-> {
            potionDAO.insertPotion(potion);
        });
    }

    public void updateImagePotion(int id, int imageId) {

        Potion p = new Potion(id, "Healing Potion",  "20% increased health", imageId);
        potionDAO.updatePotion(p);
    }


    public ImagePotion getImagePotionByName(String name){
        return potionDAO.getImagePotionByName(name);
    }

// This method is always called in request and never used on its own
    @Override
    public void getResponse(ChuckNoris chuckNoris) {
        // ADDING POTIONS TO DB + UPDATING POTION IMAGE
        Log.d("Repository", chuckNoris.toString());
    }

    @Override
    public void getListOfCategories(List<Category> categories) {
        Log.d("Repository", categories.toString());
    }

    @Override
    public void getListOfCategoryPotions(List<CategoryPotion> categoryPotions) {
        Log.d("Repository", categoryPotions.toString());
    }

    @Override
    public void getListOfImagePotions(List<ImagePotion> imagePotions) {
        Log.d("Repository", imagePotions.toString());
    }

    @Override
    public void getListOfIngredients(List<Ingredient> ingredients) {
        Log.d("Repository", ingredients.toString());
    }

    @Override
    public void getPotionsData(List<Potion> potions) {
        Log.d("Repository", potions.toString());
    }

    @Override
    public void getListOfPotionIngredients(List<PotionIngredient> potionIngredients) {
        Log.d("Repository", potionIngredients.toString());
    }

//    @Override
//    public void getResponse(List<Potions> potions) {

//        for(potion p : potions) {

//           potionDAO.insertPotion(potion);

//        ImagePotion potionImage = getImagePotionByName(p.getName);
//        int imageID =  potionImage.getImageID();
//
//        updateImagePotion(p.id, imageID);
//        }
//    }

//    class InsertPotion extends AsyncTask<Void, Void, Void> {
//
//        private Potion potion;
//
//        InsertPotion(Potion potion) {
//            this.potion = potion;
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            potionDAO.insertPotion(potion);
//            return null;
//        }
//    }

}
