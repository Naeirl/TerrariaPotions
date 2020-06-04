package com.example.terrariapotions.Repo;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.terrariapotions.Model.ChuckNoris;
import com.example.terrariapotions.Model.ImagePotion;
import com.example.terrariapotions.Model.PotionDAO;
import com.example.terrariapotions.Model.PotionDatabase;
import com.example.terrariapotions.Model.PotionNew;
import com.example.terrariapotions.R;

import java.util.List;

public class PotionRepository implements IResponse {

    private PotionDAO potionDAO;
    private PotionDatabase db;
    private static PotionRepository INSTANCE;
    private LiveData<List<PotionNew>> potions;

    private PotionRepository(Application application) {
        db = PotionDatabase.getDatabase(application);
        potionDAO = db.getPotionDAO();
        potions = potionDAO.getPotions();
    }

    public static PotionRepository getInstance(Application application) {
        if (INSTANCE == null) {
            INSTANCE = new PotionRepository(application);
        }
        return INSTANCE;
    }

    public LiveData<List<PotionNew>> getAllPotion() {
        return potions;
    }

    public void insertPotion(PotionNew potion) {
        PotionDatabase.databaseWriteExecutor.execute(()-> {
            potionDAO.insertPotion(potion);
        });
    }

    public void updateImagePotion(int id, int imageId) {

        PotionNew p = new PotionNew(id, "Healing Potion",  "20% increased health", imageId);
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
