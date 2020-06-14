package com.example.terrariapotions.Model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PotionDAO {

    @Insert
    void insertPotion(Potion potion);

    @Update
    void updatePotion(Potion potion);

    @Query("SELECT * FROM potions WHERE name = :name")
    Potion getPotionByName(String name);

    @Query("DELETE FROM potions")
    void deleteAllPotions();

    @Query("SELECT * FROM potions WHERE id = :id")
    Potion getPotionById(int id);

    @Query("SELECT * FROM potions")
    LiveData<List<Potion>> getPotions();

    @Insert
    void insertImagePotion(ImagePotion imagePotion);

    @Query("SELECT * FROM image_potion WHERE name = :name")
    ImagePotion getImagePotionByName(String name);

//    @Query("SELECT * FROM potions p, category_potion cp WHERE p.id= cp.potionId UNION SELECT" +
//            "* FROM category c, category_potion cp WHERE c.id=cp.categoryId")
//    LiveData<List<CategoryPotion>> getCategoryPotions();

}
