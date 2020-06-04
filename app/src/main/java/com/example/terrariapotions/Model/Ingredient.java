package com.example.terrariapotions.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "ingredient")
public class Ingredient {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int id;
    public String img;
    public String name;
    public String description;

    public Ingredient(@NonNull int id, String img, String name, String description) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
