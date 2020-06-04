package com.example.terrariapotions.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "potions_ingredients")
public class PotionIngredient {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int potionId;
    public int ingredientId;

    public PotionIngredient(@NonNull int potionId, int ingredientId) {
        this.potionId = potionId;
        this.ingredientId = ingredientId;
    }

    public int getPotionId() {
        return potionId;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    @Override
    public String toString() {
        return "PotionsIngredients{" +
                "potionId=" + potionId +
                ", ingredientId=" + ingredientId +
                '}';
    }
}
