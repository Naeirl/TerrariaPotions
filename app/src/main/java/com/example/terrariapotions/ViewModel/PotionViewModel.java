package com.example.terrariapotions.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.terrariapotions.Model.ImagePotion;
import com.example.terrariapotions.Model.PotionNew;
import com.example.terrariapotions.Repo.PotionRepository;

import java.util.List;

public class PotionViewModel extends AndroidViewModel {

    private PotionRepository potionRepository;
    private LiveData<List<PotionNew>> potions;

    public PotionViewModel(@NonNull Application application) {
        super(application);
        potionRepository = PotionRepository.getInstance(application);
        potions = potionRepository.getAllPotion();
    }

    public LiveData<List<PotionNew>> getPotions() {
        return potions;
    }

    public void updatePotion(int potionID, int potionImageID) {
        potionRepository.updateImagePotion(potionID, potionImageID);
    }
    public ImagePotion getImagePotionByName(String name) {
        return potionRepository.getImagePotionByName(name);
    }
}
