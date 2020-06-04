package com.example.terrariapotions.Model;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "potions")
public class PotionNew {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int id;
    public String name;
    public String description;
    public int imgId;

    public PotionNew(@NonNull int id, String name, String description, int imgId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgId = imgId;
    }

    @Override
    public String toString() {
        return "PotionNew{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imgId=" + imgId +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImgId() {
        return imgId;
    }
}
