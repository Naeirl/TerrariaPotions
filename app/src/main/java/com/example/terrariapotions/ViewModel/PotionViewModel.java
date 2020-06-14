package com.example.terrariapotions.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.terrariapotions.Model.CategoryPotion;
import com.example.terrariapotions.Model.ImagePotion;
import com.example.terrariapotions.Model.Potion;
import com.example.terrariapotions.Repo.PotionRepository;

import java.util.List;

public class PotionViewModel extends AndroidViewModel {

    private PotionRepository potionRepository;
    private LiveData<List<Potion>> potions;
    private LiveData<List<CategoryPotion>> categoryPotions;

    public PotionViewModel(@NonNull Application application) {
        super(application);
        potionRepository = PotionRepository.getInstance(application);
        potions = potionRepository.getAllPotion();
        categoryPotions = potionRepository.getAllCategoryPotions();
    }

    public LiveData<List<Potion>> getPotions() {
        return potions;
    }
    public  LiveData<List<CategoryPotion>> getCategoryPotions(){
        return categoryPotions;
    }

    public void updatePotion(int potionID, int potionImageID) {
        potionRepository.updateImagePotion(potionID, potionImageID);
    }
    public ImagePotion getImagePotionByName(String name) {
        return potionRepository.getImagePotionByName(name);
    }
}
