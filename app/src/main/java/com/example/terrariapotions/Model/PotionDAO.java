package com.example.terrariapotions.Model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PotionDAO {

    @Insert
    void insertPotion(PotionNew potionNew);

    @Update
    void updatePotion(PotionNew potionNew);

    @Query("SELECT * FROM potions WHERE name = :name")
    PotionNew getPotionByName(String name);

    @Query("DELETE FROM potions")
    void deleteAllPotions();

    @Query("SELECT * FROM potions WHERE id = :id")
    PotionNew getPotionById(int id);

    @Query("SELECT * FROM potions")
    LiveData<List<PotionNew>> getPotions();

    @Insert
    void insertImagePotion(ImagePotion imagePotion);

    @Query("SELECT * FROM image_potion WHERE name = :name")
    ImagePotion getImagePotionByName(String name);

}
