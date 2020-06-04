package com.example.terrariapotions.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "category_potion")
public class CategoryPotion {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int categoryId;
    public int potionId;

    public CategoryPotion(@NonNull int categoryId, int potionId) {
        this.categoryId = categoryId;
        this.potionId = potionId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getPotionId() {
        return potionId;
    }

    @Override
    public String toString() {
        return "CategoryPotion{" +
                "categoryId=" + categoryId +
                ", potionId=" + potionId +
                '}';
    }
}
