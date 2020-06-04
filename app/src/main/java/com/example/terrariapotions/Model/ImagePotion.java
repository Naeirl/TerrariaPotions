package com.example.terrariapotions.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "image_potion")
public class ImagePotion {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int id;
    public String name;
    public int imageID;

    public ImagePotion(int id, String name, int imageID) {
        this.id = id;
        this.name = name;
        this.imageID = imageID;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getImageID() {
        return imageID;
    }

    @Override
    public String toString() {
        return "ImagePotion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageID=" + imageID +
                '}';
    }
}
